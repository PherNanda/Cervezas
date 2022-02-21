package com.android.cervezas.data.repository


import com.android.cervezas.data.model.ResultsBeer
import com.android.cervezas.data.model.ResultsBeerItem
import com.android.cervezas.data.provider.api.BeerApi
import retrofit2.Call

class BeerRepository(private val beerApi: BeerApi) {

    suspend fun showBeers(
        beers: String,
    ): List<ResultsBeerItem> {
        return beerApi.fetchBeers(
            beers = beers
        )
    }

    suspend fun showBeersPage(
        page: Int,
        results: Int
    ): List<ResultsBeerItem> {
        return beerApi.fetchBeersPage(
            page = page,
            resultsPage = results
        )
    }

    suspend fun getBeersId(
        beerId: Int,
    ): Call<List<ResultsBeerItem>> {
        return beerApi.getBeersById(
            id = beerId
        )
    }

     suspend fun getBeersPage(
        beerPage: Int,
        resultsBeerPage: Int
    ): Call<List<ResultsBeerItem>> {
        return beerApi.getBeersList(
            page = beerPage,
            perPage = resultsBeerPage
        )
    }

    suspend fun getSearchBeers(
        beerName: String,
        beerPage: Int,
        resultsBeerPage: Int
    ): Call<List<ResultsBeerItem>>{
        return beerApi.getSearchBeer(
            beerName = beerName,
            beerPage = beerPage,
            resultsPage = resultsBeerPage
        )
    }


 }