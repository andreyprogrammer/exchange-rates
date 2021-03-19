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

    @ColumnInfo(name = "CharCode")
    var charCode: String,

    @ColumnInfo(name = "Nominal")
    var nominal: Int,

    @ColumnInfo(name = "Name")
    var name: String,

    @ColumnInfo(name = "Value")
    var amount: Double

)