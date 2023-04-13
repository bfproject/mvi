package com.architecture.data_remote.api.market

import retrofit2.http.GET

interface MarketService {
    @GET("/api/v3/ticker/price?symbols=[" +
            "\"BTCEUR\",\"ETHEUR\",\"BNBEUR\",\"XRPEUR\",\"SXPEUR\",\"LINKEUR\",\"DOTEUR\",\"LTCEUR\"," +
            "\"ADAEUR\",\"BCHEUR\",\"YFIEUR\",\"XLMEUR\",\"GRTEUR\",\"EOSEUR\",\"DOGEEUR\",\"EGLDEUR\"," +
            "\"AVAXEUR\",\"UNIEUR\"]")
    suspend fun getAssetList(): List<MarketApiModel>

}
