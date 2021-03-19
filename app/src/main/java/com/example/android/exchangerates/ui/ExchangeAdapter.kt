package com.example.android.exchangerates.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.exchangerates.databinding.ViewItemBinding
import com.example.android.exchangerates.network.Currency

class ExchangeAdapter(private val onClickListener: OnClickListener) : ListAdapter<Currency,
        ExchangeAdapter.CurrencyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExchangeAdapter.CurrencyViewHolder {
        return CurrencyViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(currency) }
        holder.bind(currency)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Currency>() {
        override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
            return oldItem.id == newItem.id
        }
    }


    class CurrencyViewHolder(private var binding: ViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency) {
            binding.currency = currency
            binding.executePendingBindings()
        }

    }

    class OnClickListener(val clickListener: (currency: Currency) -> Unit) {
        fun onClick(currency: Currency) = clickListener(currency)
    }
}