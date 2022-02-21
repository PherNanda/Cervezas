package com.android.cervezas

import com.android.cervezas.ui.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainActivityModule = module {
    viewModel {
        MainActivityViewModel(
            beerRepository = get()
        )
    }
}