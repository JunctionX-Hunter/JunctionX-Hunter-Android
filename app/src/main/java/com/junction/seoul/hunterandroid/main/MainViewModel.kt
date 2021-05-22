package com.junction.seoul.hunterandroid.main

import androidx.lifecycle.ViewModel
import com.junction.seoul.hunterandroid.data.BusNumber
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@ExperimentalCoroutinesApi
class MainViewModel: ViewModel() {

    private val _viewState = MutableStateFlow(MainViewState())
    val viewState: StateFlow<MainViewState> = _viewState

    fun searchBus(text: String) {
        // TODO 검색 api 연동
        _viewState.value = MainViewState(
            MainViewState.Status.SEARCHED,
            BusNumber(text)
        )
    }
}
