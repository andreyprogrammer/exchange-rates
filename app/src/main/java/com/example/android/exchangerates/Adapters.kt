package com.example.android.exchangerates

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.exchangerates.model.Currencies
import com.example.android.exchangerates.network.Currency
import com.example.android.exchangerates.ui.ExchangeAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: ArrayList<Currency>?) {
    val adapter = recyclerView.adapter as ExchangeAdapter
    adapter.submitList(data)
}

fun internetToDatabase(currency: Currency) =
    Currencies(
        0L,
        currency.charCode,
        currency.nominal,
        currency.name,
        currency.amount
    )

fun databaseToRecyclerview(currencies: Currencies) =
    Currency(
        currencies.charCode,
        currencies.nominal,
        currencies.name,
        currencies.amount
    )

