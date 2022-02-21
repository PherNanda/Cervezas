package com.android.cervezas.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MashTemp(

    @SerializedName("duration")
    val duration: Any,

    @SerializedName("temp")
    val temp: TempX
): Serializable