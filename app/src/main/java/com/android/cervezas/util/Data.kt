package com.android.cervezas.util

data class Data<RequestData>(
    var responseType: Status,
    var data: RequestData? = null,
    var error: Throwable? = null
)

enum class Status { SUCCESSFUL, ERROR, LOADING }