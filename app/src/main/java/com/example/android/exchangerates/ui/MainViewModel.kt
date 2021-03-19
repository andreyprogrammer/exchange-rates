package com.example.android.exchangerates.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.android.exchangerates.model.ExchangeDatabaseDao
import com.example.android.exchangerates.network.Currency
import com.example.android.exchangerates.network.ExchangeApi
import com.example.android.exchangerates.network.Valute
import kotlinx.coroutines.launch

class MainViewModel(
    val database: ExchangeDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val _properties = MutableLiveData<List<Currency>>()
    val properties: LiveData<List<Currency>>
        get() = _properties

    private val _currentCurrency = MutableLiveData<Currency>()
    val currentCurrency: LiveData<Currency>
        get() = _currentCurrency

    private val _currentAmount = MutableLiveData<String>()
    val currentAmount: LiveData<String>
        get() = _currentAmount

    private val _currentRub = MutableLiveData<String>()
    val currentRub: LiveData<String>
        get() = _currentRub

    init {
        _currentRub.value = "100"
    }

    fun exchangeRequest() {
        viewModelScope.launch {
            try {
                _properties.value = transform(ExchangeApi.retrofitService.getCurrencies().valute)

            } catch (e: Exception) {
                val c = Currency("error", "error", 1, "error", 0.1)
                val a = Valute(c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c,c)
                _properties.value = transform(a)
            }
        }
    }

    private fun transform(valute: Valute): List<Currency> {
        val listCurrencies = ArrayList<Currency>()
        listCurrencies.add(valute.amd)
        listCurrencies.add(valute.aud)
        listCurrencies.add(valute.azn)
        listCurrencies.add(valute.bgn)

        listCurrencies.add(valute.brl)
        listCurrencies.add(valute.byn)
        listCurrencies.add(valute.cad)
        listCurrencies.add(valute.chf)
        listCurrencies.add(valute.cny)

        listCurrencies.add(valute.czk)
        listCurrencies.add(valute.dkk)
        listCurrencies.add(valute.eur)
        listCurrencies.add(valute.gbp)
        listCurrencies.add(valute.hkd)

        listCurrencies.add(valute.huf)
        listCurrencies.add(valute.inr)
        listCurrencies.add(valute.jpy)
        listCurrencies.add(valute.kgs)
        listCurrencies.add(valute.krw)

        listCurrencies.add(valute.kzt)
        listCurrencies.add(valute.mdl)
        listCurrencies.add(valute.nok)
        listCurrencies.add(valute.pln)
        listCurrencies.add(valute.ron)

        listCurrencies.add(valute.sek)
        listCurrencies.add(valute.sgd)
        listCurrencies.add(valute.tjs)
        listCurrencies.add(valute.tmt)
        listCurrencies.add(valute.tr)

        listCurrencies.add(valute.uah)
        listCurrencies.add(valute.usd)
        listCurrencies.add(valute.uzs)
        listCurrencies.add(valute.xdr)
        listCurrencies.add(valute.zar)

        return listCurrencies
    }

    fun changeCurrency(currency: Currency) {
        _currentCurrency.value = currency
        onConvert(currentRub.value.toString())
    }

    private fun onConvert(text: String) {
        if (currentCurrency.value != null) {
            _currentAmount.value =
                String.format("%.2f", (text.toDouble() / currentCurrency.value?.amount!!))
        }
    }

    fun setCurrentRub(text: String) {
        _currentRub.value = text
        onConvert(text)
    }

//    fun isDBEmpty(): Boolean {
//
//        return false
//    }
//
//    private fun DBRequest() {
//        viewModelScope.launch {
//
//        }
//    }
//
//    private fun DBUpdate() {
//        viewModelScope.launch {
//
//        }
//    }
//
//    private suspend fun update(currencies: List<Currency>) {
//        database.update(currencies)
//    }
}