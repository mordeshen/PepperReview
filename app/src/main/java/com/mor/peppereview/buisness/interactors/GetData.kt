package com.mor.peppereview.buisness.interactors

import com.mor.peppereview.buisness.data.cache.CacheDataSource
import com.mor.peppereview.buisness.data.network.NetworkDataSource
import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetData constructor(
    private val cacheDataSource: CacheDataSource,
    private val networkDataSource: NetworkDataSource
) {

    private val TAG: String = "AppDebug"

    /**
     * Show loading
     * Get data from network
     * Insert data into cache
     * Show List
     */
    suspend fun execute(): Flow<DataState<List<Domain>>> = flow {
        emit(DataState.Loading)
        delay(0) //for testing
        val networkBlogs = networkDataSource.get()
        cacheDataSource.insertList(networkBlogs)
        val cachedBlogs = cacheDataSource.get()
        emit(DataState.Success(cachedBlogs))
    }

}
