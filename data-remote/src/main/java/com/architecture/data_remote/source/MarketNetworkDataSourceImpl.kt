package com.architecture.data_remote.source

import com.architecture.data_remote.api.market.MarketApiModel
import com.architecture.data_remote.api.market.MarketService
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarketNetworkDataSourceImpl @Inject constructor(private val marketService: MarketService) :
    MarketNetworkDataSource {

    override suspend fun getAssetList(): List<MarketApiModel> = marketService.getAssetList()

}
