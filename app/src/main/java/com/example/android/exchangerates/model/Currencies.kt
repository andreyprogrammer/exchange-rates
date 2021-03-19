package com.example.android.exchangerates.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.exchangerates.network.Currency

@Entity(tableName = "currencies_table")
data class Currencies(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    @ColumnInfo(name = "currencies")
    val currenciesList: List<Currency>
)