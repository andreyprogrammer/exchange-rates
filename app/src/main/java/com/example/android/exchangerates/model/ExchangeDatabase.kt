package com.example.android.exchangerates.model
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import kotlin.jvm.Volatile

@Database(entities = [Currencies::class], version = 1, exportSchema = false)
abstract class ExchangeDatabase : RoomDatabase() {

    abstract val exchangeDatabaseDao: ExchangeDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: ExchangeDatabase? = null

        fun getInstance(context: Context): ExchangeDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ExchangeDatabase::class.java,
                        "exchange_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}