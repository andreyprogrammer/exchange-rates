package com.example.android.exchangerates.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrenciesList(

    //TODO список получаемых валют, каждая отдельная валюта для парселизации:
        val id: String,
        @Json(name = "img_src") val imgSrcUrl: String,
        val type: String,
        val price: Double) : Parcelable {
//    val isRental
//        get() = type == "rent"


}