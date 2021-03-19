package com.example.android.exchangerates.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.android.exchangerates.network.Currency

@Dao
interface ExchangeDatabaseDao {
//    @Insert
//    suspend fun insert(currency: Currency)
//
//    @Update
//    suspend fun update(currency: Currency)
//
//    @Query("SELECT * from currencies_table")
//    suspend fun get(): List<Currency>
}
