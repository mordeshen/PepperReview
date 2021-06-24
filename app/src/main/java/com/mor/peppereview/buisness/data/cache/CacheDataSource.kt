package com.mor.peppereview.buisness.data.cache

import com.mor.peppereview.buisness.domain.models.Domain

interface CacheDataSource {

    suspend fun insert(domain: Domain): Long

    suspend fun insertList(data: List<Domain>)

    suspend fun get(): List<Domain>
}