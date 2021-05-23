package com.junction.seoul.hunterandroid.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivityMainBinding
import com.junction.seoul.hunterandroid.setting.AddAndDeleteTextActivity
import com.junction.seoul.hunterandroid.setting.SettingActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

  private val viewModel by viewModels<MainViewModel>()
  private lateinit var recognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding.voiceRecord.setOnClickListener {
      startStt()
    }
  }
    override fun onStart() {
        super.onStart()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.viewState.collect { viewState ->
                onViewStateChanged(viewState)
            }
        }
    }

    private fun onViewStateChanged(viewState: MainViewState) {
        when (viewState.status) {
            MainViewState.Status.SEARCH -> {
                binding.title1.text = "현재 고객님이 계신 정류장은"
                binding.title2.text = "경의선숲길공원입구"
                binding.button1.text = "즐겨찾는 버스 번호"
                binding.button2.text = "설정"

                binding.button1.setOnClickListener {
                    AddAndDeleteTextActivity.launch(this)
                }
                binding.button2.setOnClickListener {
                    SettingActivity.launch(this)
                }
            }
            MainViewState.Status.SEARCHED -> {
                binding.title1.text = "검색하신 버스 번호가 맞으십니까?"
                binding.title2.text = "5017"
                binding.button1.text = "탑승할 예정입니다"
                binding.button1.visibility = View.VISIBLE
                binding.button2.visibility = View.INVISIBLE

                binding.button1.setOnClickListener {
                    viewModel.reserveBus()
                }
            }
            MainViewState.Status.RESERVED -> {
                binding.title1.text = "고객님이 탑승하실 버스 번호는"
                binding.title2.text = "5017"
                binding.button1.text = "탑승 취소"
                binding.button1.visibility = View.VISIBLE
                binding.button2.visibility = View.INVISIBLE
                binding.voiceRecord.visibility = View.GONE
                binding.busState.visibility = View.VISIBLE

                binding.button1.setOnClickListener {
                    // TODO : 탑승 취소
                }
            }
        }
    }


  private fun startStt() {
    val neededPermission = ContextCompat.checkSelfPermission(
      this,
      Manifest.permission.RECORD_AUDIO
    ) != PackageManager.PERMISSION_GRANTED

    if (neededPermission) {
      ActivityCompat.requestPermissions(
        this, arrayOf(
          Manifest.permission.INTERNET,
          Manifest.permission.RECORD_AUDIO
        ), REQUEST_AUDIO_PERMISSION
      )
    }

    recognizer = SpeechRecognizer.createSpeechRecognizer(this)
    recognizer.setRecognitionListener(listener)
    recognizer.startListening(Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).run {
      putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
      putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")
    })
  }

  private val listener = object : RecognitionListener {
    override fun onReadyForSpeech(p0: Bundle?) {
      // 사용자가 말하기 시작할 준비가되면 호출됩니다.
      Toast.makeText(applicationContext, "음성인식을 시작", Toast.LENGTH_LONG).show()
    }

    override fun onRmsChanged(p0: Float) {
      // 입력받는 소리의 크기를 알려줍니다.
    }

    override fun onBufferReceived(p0: ByteArray?) {
      // 사용자가 말을 시작하고 인식이 된 단어를 buffer에 담습니다.
    }

    override fun onPartialResults(p0: Bundle?) {
      // 부분 인식 결과를 사용할 수 있을 때 호출됩니다.
    }

    override fun onEvent(p0: Int, p1: Bundle?) {
      // 향후 이벤트를 추가하기 위해 예약됩니다.
    }

    override fun onBeginningOfSpeech() {
      // 사용자가 말하기 시작할 준비가되면 호출됩니다.
    }

    override fun onEndOfSpeech() {
      // 사용자가 말하기를 중지하면 호출됩니다.
    }

    override fun onError(p0: Int) {
      // 네트워크 또는 인식 오류가 발생했을 때 호출됩니다.
      Toast.makeText(applicationContext, "에러가 발생하였습니다", Toast.LENGTH_LONG).show()
    }

    override fun onResults(speach: Bundle?) {
      // 인식 결과가 준비되면 호출됩니다.
      val result = speach?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) ?: return
      for (search in result) {
        Toast.makeText(applicationContext, "$result", Toast.LENGTH_LONG).show()
        //TODO result 여러개일때 search API 여러번 호출되는거 고려되야함.
        viewModel.searchBus(search)
      }
    }
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == REQUEST_AUDIO_PERMISSION && (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED))
      startStt()
  }
  companion object {
    private const val REQUEST_AUDIO_PERMISSION = 21
  }
}
