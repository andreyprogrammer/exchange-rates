package com.example.android.exchangerates.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.android.exchangerates.databaseToRecyclerview
import com.example.android.exchangerates.internetToDatabase
import com.example.android.exchangerates.model.Currencies
import com.example.android.exchangerates.model.ExchangeDatabaseDao
import com.example.android.exchangerates.network.Currency
import com.example.android.exchangerates.network.ExchangeApi
import com.example.android.exchangerates.network.Valute
import kotlinx.coroutines.launch

class MainViewModel(
    val database: ExchangeDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

    private val _properties = MutableLiveData<ArrayList<Currency>>()
    val properties: LiveData<ArrayList<Currency>>
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

    private val _isAppStarted = MutableLiveData<Boolean>()
    val isAppStarted: LiveData<Boolean>
        get() = _isAppStarted

    init {
        _currentRub.value = "100"
        _isAppStarted.value = false
    }

    fun requestFromInternet() {
        viewModelScope.launch {
            try {
                _properties.value = transform(ExchangeApi.retrofitService.getCurrencies().valute)
                clearDatabase()
                properties.value!!.forEach { a -> insertDatabase(internetToDatabase(a)) }

            } catch (e: Exception) {
                val c = Currency("error", 1, "error", 0.1)
                val v = Valute(
                    c, c, c, c, c, c, c, c, c, c, c,
                    c, c, c, c, c, c, c, c, c, c, c,
                    c, c, c, c, c, c, c, c, c, c, c, c
                )
                _properties.value = transform(v)
                clearDatabase()
                properties.value!!.forEach { a -> insertDatabase(internetToDatabase(a)) }
            }
        }
    }

    fun requestFromDatabase() {
        viewModelScope.launch {
            try {
                val listCurrencies = database.get()
                val listCurrency = ArrayList<Currency>(0)
                listCurrencies.forEach { a -> listCurrency.add(databaseToRecyclerview(a)) }

                _properties.value = listCurrency
            }
            catch (e: Exception) {}
        }
    }

    private fun transform(valute: Valute): ArrayList<Currency> {
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

    private fun insertDatabase(currencies: Currencies) {
        viewModelScope.launch {
            try {
                database.insert(currencies)
            } catch (e: Exception) {

            }
        }
    }

    private fun clearDatabase() {
        viewModelScope.launch {
            database.clear()
        }
    }

    fun setAppStarted(bool: Boolean) {
        _isAppStarted.value = bool
    }
}