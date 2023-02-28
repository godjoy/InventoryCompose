package com.example.inventorycompose.ui.inventory.tree

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inventorycompose.ui.model.TreeItem
import com.example.inventorycompose.ui.model.mockTreeItem
import com.example.inventorycompose.ui.util.mapToDrawableId

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TreeCard(
    treeItem: TreeItem,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var color = Color.Transparent
    if (treeItem.isSelected) color = Color.Green

    Card(
        shape = RoundedCornerShape(5.dp),
        backgroundColor = Color.LightGray,
        elevation = 0.dp,
        modifier = modifier
            .width(53.dp)
            .height(58.dp)
            .border(2.dp, color, shape = RoundedCornerShape(5.dp)),
        onClick = { onSelect(treeItem.id) }
    ) {
        Image(
            painter = painterResource(treeItem.id.mapToDrawableId()),
            contentDescription = null,
            contentScale = ContentScale.Inside
        )
    }
}

@Preview
@Composable
fun TreeCardPreview() {
    TreeCard(treeItem = mockTreeItem, { })
}