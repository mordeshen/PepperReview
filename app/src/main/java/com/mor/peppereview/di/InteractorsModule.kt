package com.mor.peppereview.di


import com.mor.peppereview.buisness.data.cache.CacheDataSource
import com.mor.peppereview.buisness.data.network.NetworkDataSource
import com.mor.peppereview.buisness.interactors.GetData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetBlogs(
        cacheDataSource: CacheDataSource,
        networkDataSource: NetworkDataSource
    ): GetData {
        return GetData(cacheDataSource, networkDataSource)
    }
}














