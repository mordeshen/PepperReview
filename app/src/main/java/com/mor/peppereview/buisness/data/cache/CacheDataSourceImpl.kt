package com.mor.peppereview.buisness.data.cache

import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.framework.datasource.cache.WeatherDataDaoService
import com.mor.peppereview.framework.datasource.cache.mappers.CacheMapper

class CacheDataSourceImpl
constructor(
    private val daoService: WeatherDataDaoService,
    private val cacheMapper: CacheMapper
) : CacheDataSource {
    override suspend fun insert(domain: Domain): Long {
        return daoService.insert(cacheMapper.mapToEntity(domain))
    }

    override suspend fun insertList(data: List<Domain>) {
        for (weather in data) {
            daoService.insert(cacheMapper.mapToEntity(weather))
        }
    }

    override suspend fun get(): List<Domain> {
        return cacheMapper.mapFromEntityList(daoService.get())
    }


}
