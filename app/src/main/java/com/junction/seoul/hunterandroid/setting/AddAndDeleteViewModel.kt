package com.junction.seoul.hunterandroid.setting

import androidx.lifecycle.ViewModel
import com.junction.seoul.hunterandroid.data.BusNumber
import com.junction.seoul.hunterandroid.data.makeBusNumbers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
class AddAndDeleteViewModel : ViewModel() {

  private val _busNumbers = MutableStateFlow(mutableListOf(BusNumber("init")))
  val busNumber: StateFlow<MutableList<BusNumber>>
    get() = _busNumbers

  private val _showDeleteDialog = MutableStateFlow(false)
  val showDeleteDialog: StateFlow<Boolean>
    get() = _showDeleteDialog

  //TODO Room을 이용하여 local에서 가져오게 수정 필요.
  fun updateBusNumbers() {
    _busNumbers.value = makeBusNumbers()
  }

  //TODO 추가하기 버튼과 연동 필요.
  private fun addBusNumbers(busNumber: BusNumber) {
    _busNumbers.value.add(busNumber)
  }

  fun showDeleteDialog() {
    _showDeleteDialog.value = true
    //TODO 다이얼로그에서 삭제 버튼 누른 뒤 삭제
    //deleteBusNumber()
  }

  private fun deleteBusNumber(busNumber: BusNumber) {
    //_busNumbers.value.remove(busNumber)

  }

}