package com.android.cervezas.data.provider.api

import com.android.cervezas.data.model.ResultsBeer
import com.android.cervezas.data.model.ResultsBeerItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BeerApi {

    @Headers("Accept: application/json")
    @GET(".")
     fun fetchBeers(
        @Query("beers ") beers: String
    ): List<ResultsBeerItem>


    @Headers("Accept: application/json")
    @GET(".")
     fun fetchBeersPage(
        @Query(value = "page") page: Int,
        @Query(value = "per_page") resultsPage: Int,
    ): List<ResultsBeerItem>


    @GET("beers")
     fun getBeersById(
        @Query("ids") id: Int
    ): Call<List<ResultsBeerItem>>

    @GET("beers")
     fun getBeersList(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<List<ResultsBeerItem>>

    @GET("beers")
     fun getSearchBeer(
        @Query("beer_name") beerName: String,
        @Query("page") beerPage: Int,
        @Query("per_page") resultsPage: Int
    ): Call<List<ResultsBeerItem>>

}