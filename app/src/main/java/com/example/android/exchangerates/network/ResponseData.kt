package com.example.android.exchangerates.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BigData(
    @Expose
    @SerializedName("Date")
    var date: String,

    @Expose
    @SerializedName("PreviousDate")
    var PreviousDate: String,

    @Expose
    @SerializedName("PreviousURL")
    var PreviousURL: String,

    @Expose
    @SerializedName("Timestamp")
    var Timestamp: String,

    @Expose
    @SerializedName("Valute")
    var valute: Valute

)