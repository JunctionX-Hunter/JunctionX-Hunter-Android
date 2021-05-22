package com.junction.seoul.hunterandroid.main

data class MainViewState(
    val status: Status = Status.SEARCH
) {
    enum class Status {
        SEARCH, // 메인
        SEARCHED, // 메인_결과안내
        RESERVED, // 메인_예약 대기중
    }
}
