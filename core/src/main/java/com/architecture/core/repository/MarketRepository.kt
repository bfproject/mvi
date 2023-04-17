package com.architecture.core.repository

import com.architecture.core.model.Asset
import kotlinx.coroutines.flow.Flow

interface MarketRepository {

    fun getAssetList(): Flow<List<Asset>>

}
