package com.architecture.feature_market

import com.architecture.core.state.UiAction

sealed class MarketUiAction: UiAction {

    object Load : MarketUiAction()

}
