package com.junction.seoul.hunterandroid.data

data class BusNumber(
  val title: String
)

//TODO 저장된 버스 숫자 가져오도록 수정 필요
fun makeBusNumbers(): MutableList<BusNumber> {
  val list = mutableListOf<BusNumber>()
  list.add(BusNumber("6172"))
  list.add(BusNumber("8172"))
  list.add(BusNumber("60-2"))
  list.add(BusNumber("1117"))
  list.add(BusNumber("2000-1"))
  return list
}