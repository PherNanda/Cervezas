package com.android.cervezas.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Malt(

    @SerializedName("amount")
    val amount: AmountX,

    @SerializedName("name")
    val name: String
): Serializable