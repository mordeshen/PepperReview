package com.mor.peppereview.framework.datasource.cache

import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity

interface WeatherDataDaoService {

    suspend fun insert(weatherCacheEntity: WeatherCacheEntity): Long

    suspend fun get(): List<WeatherCacheEntity>
}