package com.mor.peppereview.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity

@Database(entities = [WeatherCacheEntity::class], version = 1)
@TypeConverters
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        val DATABASE_NAME = "weather_db"
    }
}