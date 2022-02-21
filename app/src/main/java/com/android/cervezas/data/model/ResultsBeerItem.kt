package com.android.cervezas.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResultsBeerItem(
    @SerializedName("abv")
    val abv: Double,

    @SerializedName("attenuation_level")
    val attenuation_level: Double,

    @SerializedName("boil_volume")
    val boil_volume: BoilVolume,

    @SerializedName("brewers_tips")
    val brewers_tips: String,

    @SerializedName("contributed_by")
    val contributed_by: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("ebc")
    val ebc: Int,

    @SerializedName("first_brewed")
    val first_brewed: String,

    @SerializedName("food_pairing")
    val food_pairing: List<String>,

    @SerializedName("ibu")
    val ibu: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("image_url")
    val image_url: String,

    @SerializedName("ingredients")
    val ingredients: Ingredients,

    @SerializedName("method")
    val method: Method,

    @SerializedName("name")
    val name: String,

    @SerializedName("ph")
    val ph: Double,

    @SerializedName("srm")
    val srm: Int,

    @SerializedName("tagline")
    val tagline: String,

    @SerializedName("target_fg")
    val target_fg: Int,

    @SerializedName("target_og")
    val target_og: Int,

    @SerializedName("volume")
    val volume: Volume
): Serializable