package com.example.android.exchangerates.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(

    @Expose
    @SerializedName("Valute")
    var valute: Valute

)