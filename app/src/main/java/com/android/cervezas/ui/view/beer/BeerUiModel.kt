package com.android.cervezas.ui.view.beer

import android.os.Parcelable
import com.android.cervezas.data.model.ResultsBeerItem
import com.android.cervezas.ui.UiModel
import kotlinx.parcelize.Parcelize
import java.util.*

sealed class BeerUiModel : UiModel() {


    data class Street(
        val number: String,
        val name: String,
    )

    @Parcelize
    data class Beer(
        override val uid: Long = UUID.randomUUID().leastSignificantBits,
        val abv: Double,
        val attenuation_level: Double,
        val brewers_tips: String,
        val contributed_by: String,
        val description: String,
        val ebc: Int,
        val first_brewed: String,
        val food_pairing: List<String>,
        val ibu: Int,
        val id: Int,
        val image_url: String,
        val name: String,
        val ph: Double,
        val srm: Int,
        val tagline: String,
        val target_fg: Int,
        val target_og: Int,
    ) : BeerUiModel(), Parcelable

}


fun ResultsBeerItem.toBeerUiModel(): BeerUiModel.Beer{
    return BeerUiModel.Beer(
    abv = abv,
    attenuation_level = attenuation_level,
    brewers_tips = brewers_tips,
    contributed_by = contributed_by,
    description = description,
    ebc = ebc,
    first_brewed = first_brewed,
    food_pairing = food_pairing,
    ibu = ibu,
    id = id,
    image_url = image_url,
    name = name,
    ph = ph,
    srm = srm,
    tagline = tagline,
    target_fg = target_fg,
    target_og = target_og,

    )

}
