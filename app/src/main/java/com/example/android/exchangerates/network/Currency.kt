package com.example.android.exchangerates.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Currency(

    @Expose
    @SerializedName("ID")
    var id: String,

    @SerializedName("CharCode")
    @Expose
    var charCode: String,

    @SerializedName("Nominal")
    @Expose
    var nominal: Int,

    @SerializedName("Name")
    @Expose
    var name: String,

    @SerializedName("Value")
    @Expose
    var amount: Double

) {
    fun amountToString(): String {
        return amount.toString()
    }
}
