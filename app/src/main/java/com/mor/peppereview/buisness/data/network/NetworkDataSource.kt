package com.mor.peppereview.buisness.data.network

import com.mor.peppereview.buisness.domain.models.Domain


interface NetworkDataSource {
    suspend fun get(): List<Domain>
}