package com.mor.peppereview.framework.datasource.network

import com.mor.peppereview.framework.datasource.network.model.WeatherNetworkEntity

interface WeatherRetrofitService {
    suspend fun get(
        lat: Double,
        lon: Double,
        amountOfCities: Int,
        appid: String
    ): List<WeatherNetworkEntity>
}