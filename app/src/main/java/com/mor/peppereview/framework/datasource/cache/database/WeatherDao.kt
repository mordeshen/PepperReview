package com.mor.peppereview.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weatherEntity: WeatherCacheEntity): Long

    @Query("SELECT * FROM weather_db")
    suspend fun get(): List<WeatherCacheEntity>

}