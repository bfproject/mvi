package com.architecture.data_remote.source

import com.architecture.data_remote.api.market.MarketApiModel
import kotlinx.coroutines.flow.Flow

interface MarketNetworkDataSource {

    fun getAssetList(): Flow<List<MarketApiModel>>

}
