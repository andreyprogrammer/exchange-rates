package com.example.android.exchangerates.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.cbr-xml-daily.ru"

private val gson = GsonBuilder()
    .excludeFieldsWithoutExposeAnnotation()
    .create()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

interface ExchangeApiService {
    @GET("daily_json.js")
    suspend fun getCurrencies(): ResponseData
}

object ExchangeApi {
    val retrofitService: ExchangeApiService by lazy { retrofit.create(ExchangeApiService::class.java) }
}