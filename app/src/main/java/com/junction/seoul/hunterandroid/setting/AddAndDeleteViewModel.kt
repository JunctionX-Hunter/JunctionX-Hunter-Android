package com.junction.seoul.hunterandroid.setting

import androidx.lifecycle.ViewModel
import com.junction.seoul.hunterandroid.data.BusNumber
import com.junction.seoul.hunterandroid.data.makeBusNumbers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddAndDeleteViewModel : ViewModel() {

  private val _busNumbers = MutableStateFlow(mutableListOf(BusNumber("init")))
  val busNumbers: StateFlow<MutableList<BusNumber>>
    get() = _busNumbers

  private val _pickBus = MutableStateFlow(BusNumber(null))
  val pickBus: StateFlow<BusNumber>
    get() = _pickBus

  //TODO Room을 이용하여 local에서 가져오게 수정 필요.
  fun updateBusNumbers() {
    _busNumbers.value = makeBusNumbers()
  }

  //TODO 추가하기 버튼과 연동 필요.
  private fun addBusNumbers(busNumber: BusNumber) {
    _busNumbers.value.add(busNumber)
  }

  fun showDeleteDialog(busNumber: BusNumber) {
    _pickBus.value = busNumber
  }

  fun deleteBusNumber() {
    val removedList = _busNumbers.value.filterNot { it == pickBus.value }
    _busNumbers.value.clear()
    _busNumbers.value = removedList.toMutableList()
  }
}