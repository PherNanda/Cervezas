package com.android.cervezas.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TempX(

    @SerializedName("unit")
    val unit: String,

    @SerializedName("value")
    val value: Int

): Serializable