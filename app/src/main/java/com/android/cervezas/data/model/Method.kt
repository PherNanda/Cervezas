package com.android.cervezas.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Method(

    @SerializedName("fermentation")
    val fermentation: Fermentation,

    @SerializedName("mash_temp")
    val mash_temp: List<MashTemp>,

    @SerializedName("twist")
    val twist: Any
): Serializable