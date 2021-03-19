package com.example.android.exchangerates.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Valute(

    @Expose
    @SerializedName("AUD")
    var aud: Currency,

    @Expose
    @SerializedName("AZN")
    var azn: Currency,

    @SerializedName("GBP")
    @Expose
    var gbp: Currency,

    @SerializedName("AMD")
    @Expose
    var amd: Currency,

    @SerializedName("BYN")
    @Expose
    var byn: Currency,

    @SerializedName("BGN")
    @Expose
    var bgn: Currency,

    @SerializedName("BRL")
    @Expose
    var brl: Currency,

    @SerializedName("HUF")
    @Expose
    var huf: Currency,

    @SerializedName("HKD")
    @Expose
    var hkd: Currency,

    @SerializedName("DKK")
    @Expose
    var dkk: Currency,

    @SerializedName("USD")
    @Expose
    var usd: Currency,

    @SerializedName("EUR")
    @Expose
    var eur: Currency,

    @SerializedName("INR")
    @Expose
    var inr: Currency,

    @SerializedName("KZT")
    @Expose
    var kzt: Currency,

    @SerializedName("CAD")
    @Expose
    var cad: Currency,

    @SerializedName("KGS")
    @Expose
    var kgs: Currency,

    @SerializedName("CNY")
    @Expose
    var cny: Currency,

    @SerializedName("MDL")
    @Expose
    var mdl: Currency,

    @SerializedName("NOK")
    @Expose
    var nok: Currency,

    @SerializedName("PLN")
    @Expose
    var pln: Currency,

    @SerializedName("RON")
    @Expose
    var ron: Currency,

    @SerializedName("XDR")
    @Expose
    var xdr: Currency,

    @SerializedName("SGD")
    @Expose
    var sgd: Currency,

    @SerializedName("TJS")
    @Expose
    var tjs: Currency,

    @SerializedName("TRY")
    @Expose
    var tr: Currency,

    @SerializedName("TMT")
    @Expose
    var tmt: Currency,

    @SerializedName("UZS")
    @Expose
    var uzs: Currency,

    @SerializedName("UAH")
    @Expose
    var uah: Currency,

    @SerializedName("CZK")
    @Expose
    var czk: Currency,

    @SerializedName("SEK")
    @Expose
    var sek: Currency,

    @SerializedName("CHF")
    @Expose
    var chf: Currency,

    @SerializedName("ZAR")
    @Expose
    var zar: Currency,

    @SerializedName("KRW")
    @Expose
    var krw: Currency,

    @SerializedName("JPY")
    @Expose
    var jpy: Currency
)