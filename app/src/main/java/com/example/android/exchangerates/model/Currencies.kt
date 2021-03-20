package com.example.android.exchangerates.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.exchangerates.network.Currency
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "currencies_table")
data class Currencies(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,

    var charCode: String,

    var nominal: Int,

    var name: String,

    var amount: Double
)