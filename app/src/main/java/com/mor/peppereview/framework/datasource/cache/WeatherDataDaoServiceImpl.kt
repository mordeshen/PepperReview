package com.mor.peppereview.framework.datasource.cache

import com.mor.peppereview.framework.datasource.cache.database.WeatherDao
import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity

class WeatherDataDaoServiceImpl
constructor(
    private val dao: WeatherDao
) : WeatherDataDaoService {
    override suspend fun insert(weatherCacheEntity: WeatherCacheEntity): Long {
        return dao.insert(weatherCacheEntity)
    }

    override suspend fun get(): List<WeatherCacheEntity> {
        return dao.get()
    }
}