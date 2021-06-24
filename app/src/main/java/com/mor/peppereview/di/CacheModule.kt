package com.mor.peppereview.di

import android.content.Context
import androidx.room.Room
import com.mor.peppereview.buisness.data.cache.CacheDataSource
import com.mor.peppereview.buisness.data.cache.CacheDataSourceImpl
import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.util.EntityMapper
import com.mor.peppereview.framework.datasource.cache.WeatherDataDaoService
import com.mor.peppereview.framework.datasource.cache.WeatherDataDaoServiceImpl
import com.mor.peppereview.framework.datasource.cache.database.WeatherDao
import com.mor.peppereview.framework.datasource.cache.database.WeatherDatabase
import com.mor.peppereview.framework.datasource.cache.mappers.CacheMapper
import com.mor.peppereview.framework.datasource.cache.model.WeatherCacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<WeatherCacheEntity, Domain> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideWeatherDb(@ApplicationContext context: Context): WeatherDatabase {
        return Room
            .databaseBuilder(
                context,
                WeatherDatabase::class.java,
                WeatherDatabase.DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideWeatherDAO(weatherDatabase: WeatherDatabase): WeatherDao {
        return weatherDatabase.weatherDao()
    }

    @Singleton
    @Provides
    fun provideWeatherDaoService(
        weatherDao: WeatherDao
    ): WeatherDataDaoService {
        return WeatherDataDaoServiceImpl(weatherDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        weatherDataDaoService: WeatherDataDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(weatherDataDaoService, cacheMapper)
    }


}

























