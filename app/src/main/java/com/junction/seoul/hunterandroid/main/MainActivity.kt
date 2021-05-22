package com.junction.seoul.hunterandroid.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.junction.seoul.hunterandroid.R
import com.junction.seoul.hunterandroid.base.BaseActivity
import com.junction.seoul.hunterandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect

@ExperimentalCoroutinesApi
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.voiceRecord.setOnClickListener {
            // TODO : 음성 인식후 그 결과를 전달하도록 변경
            viewModel.searchBus("5017")
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
                    // TODO : 즐겨찾는 버스 번호
                }
                binding.button2.setOnClickListener {
                    // TODO : 설정
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
}
