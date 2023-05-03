package com.architecture.feature_market

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.architecture.core.model.Asset
import com.architecture.core.repository.MarketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MarketViewModel @Inject constructor(private val marketRepository: MarketRepository) : ViewModel() {

    private val _uiStateFlow: MutableStateFlow<List<Asset>> = MutableStateFlow(emptyList())
    val uiStateFlow: StateFlow<List<Asset>> = _uiStateFlow
    private val actionFlow: MutableSharedFlow<MarketUiAction> = MutableSharedFlow()

    init {
        viewModelScope.launch {
            actionFlow.collect {
                handleAction(it)
            }
        }
    }

    fun handleAction(action: MarketUiAction) {
        when (action) {
            is MarketUiAction.Load -> {
                loadAssetList()
            }
        }
    }

    fun submitAction(action: MarketUiAction) {
        viewModelScope.launch {
            actionFlow.emit(action)
        }
    }

    fun submitState(state: List<Asset>) {
        viewModelScope.launch {
            _uiStateFlow.value = state
        }
    }

    private fun loadAssetList() {
        viewModelScope.launch {
            marketRepository.getAssetList().collect {
                submitState(it)
            }
        }
    }

}
