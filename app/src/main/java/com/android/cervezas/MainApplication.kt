package com.android.cervezas

import android.app.Application
import android.os.StrictMode
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application()  {

    override fun onCreate() {
        applicationContext.setTheme(R.style.Theme_MaterialComponents_Light)
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(koinModules)
        }


    }
}