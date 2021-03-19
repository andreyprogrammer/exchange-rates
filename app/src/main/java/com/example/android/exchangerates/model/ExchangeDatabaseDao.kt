package com.example.android.exchangerates.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android.exchangerates.network.Currency

@Dao
interface ExchangeDatabaseDao {
//    @Insert
//    suspend fun insert(currencies: List<Currency>)
//
//    @Update
//    suspend fun update(currencies: List<Currency>)
//
//    @Query("SELECT * from currencies_table")
//    suspend fun get(): List<Currency>
}
