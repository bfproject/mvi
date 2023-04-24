package com.architecture.data_repository.model

import com.architecture.core.model.Asset
import com.architecture.data_remote.api.market.MarketApiModel

fun MarketApiModel.asUiModel() = Asset(symbol = symbol, price = price)
