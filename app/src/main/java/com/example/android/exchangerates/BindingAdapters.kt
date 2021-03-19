package com.example.android.exchangerates

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.exchangerates.network.Currency
import com.example.android.exchangerates.ui.ExchangeAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Currency>?) {
    val adapter = recyclerView.adapter as ExchangeAdapter
    adapter.submitList(data)
}