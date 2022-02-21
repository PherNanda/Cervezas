package com.android.cervezas.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.AppBarConfiguration
import com.android.cervezas.databinding.ActivityMainBinding
import com.android.cervezas.koinModules
import com.android.cervezas.ui.view.beer.BeerUiModel
import com.android.cervezas.ui.viewmodel.MainActivityViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModel<MainActivityViewModel>()

    private var user: MutableList<BeerUiModel.Beer> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadBeers()
        //setSupportActionBar(binding.toolbar)
    }


    private fun loadBeers(){
        viewModel.loadBeersPage(0, 10)
    }

    override fun onResume() {
        super.onResume()
        loadBeers()
    }
}