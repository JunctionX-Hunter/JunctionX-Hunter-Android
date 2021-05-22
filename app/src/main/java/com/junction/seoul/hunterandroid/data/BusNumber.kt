package com.junction.seoul.hunterandroid.data

data class BusNumber(
  val busNumber: String
)

//TODO 저장된 버스 숫자 가져오도록 수정 필요
fun makeBusNumbers(): MutableList<BusNumber> {
  val list = mutableListOf<BusNumber>()
  for (i in 0..5) {
    list.add(BusNumber("100$i"))
  }
  return list
}