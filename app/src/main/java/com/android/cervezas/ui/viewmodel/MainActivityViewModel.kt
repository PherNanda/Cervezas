package com.android.cervezas.ui.viewmodel


import androidx.lifecycle.*
import com.android.cervezas.data.model.ResultsBeer
import com.android.cervezas.data.model.ResultsBeerItem
import com.android.cervezas.data.repository.BeerRepository
import com.android.cervezas.domain.Result
import com.android.cervezas.ui.view.beer.BeerUiModel
import com.android.cervezas.util.Data
import com.android.cervezas.util.Status
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber



class MainActivityViewModel (
    private val beerRepository: BeerRepository,
    ) : ViewModel() {

    private var usersPageNumber = 0

    private val _beers: MutableLiveData<List<BeerUiModel.Beer>> = MutableLiveData(listOf())
    val beers: LiveData<List<BeerUiModel.Beer>> = _beers
    val beersList: LiveData<List<BeerUiModel.Beer>> = _beers

    private var _beer: MutableLiveData<BeerUiModel.Beer> = MutableLiveData()
    val user: LiveData<BeerUiModel.Beer> = _beer

    /**init {
        println("INIT MainActivityViewModel")
        loadBeers("beers")
    }**/

    fun search(firstName: String){

        if (firstName.length < LENGTH_SEARCH){
            _beers.value = loadBeersPage(0,PAGE_LIMIT)
            usersPageNumber = 0
        }else {
            searchUser(firstName)
        }

    }

    fun loadBeersPage(page: Int, resultsPage: Int): MutableList<BeerUiModel.Beer> {
        println("loadBeersPage... MainActivityViewModel")
        var listOut = _beers.value?.toMutableList() ?: mutableListOf()
        viewModelScope.launch {
            val result = runCatching {
                val response =
                    beerRepository.getBeersPage(
                        page,
                        resultsPage
                    )
            }

            if (result.isSuccess) {
                println("TEST BEER isSuccess")
                val list = _beers.value?.toMutableList() ?: mutableListOf()

            }
            if (result.isFailure) {
                println("TEST BEER isFailure")
            }

            val test = result.getOrDefault(_beers.value)

            println("testX $test")

            val testTwo = result.getOrThrow().toString()

            println("testTwo $testTwo")

            val exception = result.exceptionOrNull()
            if (exception != null && exception !is CancellationException) {

                Timber.e(exception.message.toString())
                Timber.e("Error us: ${exception.stackTrace}")
                Timber.e("ERROR us: ${exception.stackTraceToString()}")

                println("\nTEST BEER Failure ${exception.message.toString()}")
                println("\nTEST BEER Failure ${exception.stackTrace}}")
                println("\nTEST BEER Failure ${exception.stackTraceToString()}")
            }
        }

        return listOut
    }

    private fun searchUser(nameSearch: String): List<BeerUiModel.Beer> {

        viewModelScope.launch {

            val filteredList = _beers.value?.filter { it.name.lowercase() == nameSearch.lowercase() }

            if (filteredList != null) {

                if (filteredList.isNotEmpty()){
                    _beers.value = filteredList.distinctBy { Pair(it.tagline, it.name) }

                }
            }

        }
        return _beers.value?: mutableListOf()
    }

    companion object {
        const val PAGE_LIMIT = 10
        const val LENGTH_SEARCH = 3
    }

}