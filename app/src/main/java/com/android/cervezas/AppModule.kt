package com.android.cervezas

import com.android.cervezas.data.provider.ApiProvider
import com.android.cervezas.data.repository.BeerRepository
import com.squareup.moshi.Moshi
import org.koin.dsl.module

val appModule = module {
    single {
        ApiProvider()
    }

    single {
        Moshi.Builder().build()
    }

    factory {
        BeerRepository(
            beerApi = get<ApiProvider>().beerApi
        )
    }

}