package com.architecture.data_remote.api.market

import com.squareup.moshi.Json

data class MarketApiModel(
    @Json(name = "symbol") val symbol: String = "",
    @Json(name = "price") val price: String = "",
)
