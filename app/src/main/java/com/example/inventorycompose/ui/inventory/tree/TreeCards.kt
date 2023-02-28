package com.example.inventorycompose.ui.inventory.tree

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.inventorycompose.ui.model.TreeItem
import com.example.inventorycompose.ui.model.mockTreeList

@Composable
fun TreeCards(
    trees: List<TreeItem>,
    onSelect: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 20.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = trees, key = { tree -> tree.id }
        ) { treeState ->
            TreeCard(
                treeState,
                { onSelect(treeState.id) }
            )
        }
    }
}

@Preview
@Composable
fun TreeCardsPreview() {
    TreeCards(trees = mockTreeList, { })
}