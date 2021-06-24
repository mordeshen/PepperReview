package com.mor.peppereview.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mor.peppereview.buisness.data.network.NetworkDataSource
import com.mor.peppereview.buisness.data.network.NetworkDataSourceImpl
import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.util.EntityMapper
import com.mor.peppereview.framework.datasource.network.WeatherRetrofitService
import com.mor.peppereview.framework.datasource.network.WeatherRetrofitServiceImpl
import com.mor.peppereview.framework.datasource.network.mappers.NetworkMapper
import com.mor.peppereview.framework.datasource.network.model.WeatherNetworkEntity
import com.mor.peppereview.framework.datasource.network.retrofit.WeatherRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<WeatherNetworkEntity, Domain> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideWeatherService(retrofit: Retrofit.Builder): WeatherRetrofit {
        return retrofit
            .build()
            .create(WeatherRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(
        weatherRetrofit: WeatherRetrofit
    ): WeatherRetrofitService {
        return WeatherRetrofitServiceImpl(weatherRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        weatherRetrofitService: WeatherRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(weatherRetrofitService, networkMapper)
    }

}




















