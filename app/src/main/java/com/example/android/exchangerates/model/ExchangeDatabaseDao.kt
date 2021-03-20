package com.example.android.exchangerates.model

import androidx.room.*
import com.example.android.exchangerates.network.Currency

@Dao
interface ExchangeDatabaseDao {
    @Insert
    suspend fun insert(currencies: Currencies)

    @Update
    suspend fun update(currencies: Currencies)

    @Query("SELECT * from currencies_table")
    suspend fun get(): List<Currencies>

    @Query("DELETE FROM currencies_table")
    suspend fun clear()
}
