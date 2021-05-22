package com.junction.seoul.hunterandroid.main

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
            }
            MainViewState.Status.SEARCHED -> TODO()
            MainViewState.Status.RESERVED -> TODO()
        }
    }
}
