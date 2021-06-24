package com.mor.peppereview.framework.datasource.network

import com.mor.peppereview.framework.datasource.network.model.WeatherNetworkEntity
import com.mor.peppereview.framework.datasource.network.retrofit.WeatherRetrofit

class WeatherRetrofitServiceImpl
constructor(
    private val weatherRetrofit: WeatherRetrofit
) : WeatherRetrofitService {

    override suspend fun get(
        lat: Double,
        lon: Double,
        amountOfCities: Int,
        appid: String
    ): List<WeatherNetworkEntity> {
        return weatherRetrofit.get(lat, lon, amountOfCities, appid)
    }
}