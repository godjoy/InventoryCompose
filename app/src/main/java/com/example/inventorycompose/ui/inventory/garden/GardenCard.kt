package com.example.inventorycompose.ui.inventory.garden

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.inventorycompose.ui.model.GardenItem
import com.example.inventorycompose.ui.model.GardenType

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GardenCard(
    modifier: Modifier = Modifier,
    gardenItem: GardenItem,
    onSelect: (Int) -> Unit
) {
    val backgroundColor =
        if (gardenItem.type == GardenType.Selected) Color.Yellow else Color.White
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .aspectRatio(1f / 1f)
            .border(width = 2.dp, color = Color.Green, RoundedCornerShape(4.dp)),
        backgroundColor = backgroundColor,
        onClick = { onSelect(gardenItem.location) }
    ) {
        gardenItem.treeId?.let {
            Text(
                text = "$it",
                modifier = modifier.wrapContentHeight(),
                textAlign = TextAlign.Center
            )
        }
    }
}