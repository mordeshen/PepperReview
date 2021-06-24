package com.mor.peppereview.framework.datasource.network.retrofit

import com.mor.peppereview.framework.datasource.network.model.WeatherNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRetrofit {

    //ex. for review https://api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=18f27d6ac052eb93e6030e7ddb5cde31
    @GET("find")
    suspend fun get(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("cnt") amountOfCities: Int,
        @Query("appid") appid: String
    ): List<WeatherNetworkEntity>
}