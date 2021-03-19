package com.example.android.exchangerates.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Curr(
    @Expose
    @SerializedName("Valute")
    var Valute: List<Au>


)