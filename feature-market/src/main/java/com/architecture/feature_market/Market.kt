package com.architecture.feature_market

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.architecture.core.model.Asset

@Composable
fun MarketScreen(viewModel: MarketViewModel = viewModel()) {

    viewModel.uiStateFlow.collectAsState().value.let {
        LazyColumn {
            items(it) { item ->
                AssetListItem(item)
            }

        }
    }
    LaunchedEffect(Unit) {
        viewModel.submitAction(MarketUiAction.Load)
    }
}

@Composable
fun AssetListItem(item: Asset) {
    ElevatedCard(modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            Text(item.symbol)
            Text("${item.price}€")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AssetListItemPreview() {
    AssetListItem(item = Asset("Symbol", "1000"))
}
