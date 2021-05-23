package com.junction.seoul.hunterandroid.main

import com.junction.seoul.hunterandroid.data.BusNumber

data class MainViewState(
    val status: Status = Status.SEARCH,
    val busNumber: BusNumber? = null
) {
    enum class Status {
        SEARCH, // 메인
        SEARCHED, // 메인_결과안내
        RESERVED, // 메인_예약 대기중
    }
}
