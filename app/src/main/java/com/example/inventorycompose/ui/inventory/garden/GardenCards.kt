package com.example.inventorycompose.ui.inventory.garden

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorycompose.ui.model.GardenItem
import com.example.inventorycompose.ui.model.GardenType

@Composable
fun GardenCards(
    modifier: Modifier = Modifier,
    garden: List<GardenItem>,
    onSelect: (Int) -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        columns = GridCells.Fixed(6),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(items = garden, key = { item: GardenItem -> item.location }) { gardenItem ->
            when(gardenItem.type) {
                GardenType.Lake -> GardenLakeCard()
                GardenType.Planted -> GardenPlantedCard(gardenItem = gardenItem)
                GardenType.Selected, GardenType.Empty ->
                    GardenCard(gardenItem = gardenItem) { onSelect(gardenItem.location) }
            }
        }
    }
}