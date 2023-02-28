package com.example.inventorycompose.ui.inventory.garden

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GardenLakeCard(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .aspectRatio(1f / 1f),
        backgroundColor = Color.Blue
    ) {}
}

@Preview
@Composable
fun LakeCardPreView() {
    GardenLakeCard()
}