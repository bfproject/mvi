package com.architecture.data_repository

import com.architecture.core.model.Asset
import com.architecture.core.repository.MarketRepository
import com.architecture.data_remote.api.market.MarketApiModel
import com.architecture.data_remote.source.MarketNetworkDataSource
import com.architecture.data_repository.model.asUiModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MarketRepositoryImpl @Inject constructor(private val marketNetworkDataSource: MarketNetworkDataSource) :
    MarketRepository {

    override fun getAssetList(): Flow<List<Asset>> = flow {
        val assetList = marketNetworkDataSource.getAssetList()
            .map(MarketApiModel::asUiModel)
        emit(assetList)
    }

}
