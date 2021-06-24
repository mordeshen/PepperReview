package com.mor.peppereview.buisness.data.network

import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.framework.datasource.network.WeatherRetrofitService
import com.mor.peppereview.framework.datasource.network.mappers.NetworkMapper

class NetworkDataSourceImpl
constructor(
    private val retrofitService: WeatherRetrofitService,
    private val networkMapper: NetworkMapper
) : NetworkDataSource {

    override suspend fun get(): List<Domain> {
        return networkMapper.mapFromEntityList(retrofitService.get())
    }

}