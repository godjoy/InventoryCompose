package com.example.inventorycompose.ui.inventory

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorycompose.ui.model.TreeState
import com.example.inventorycompose.viewmodel.InventoryViewModel

@Composable
fun InventoryScreen(
    modifier: Modifier = Modifier,
    viewModel: InventoryViewModel = hiltViewModel()
) {
    val trees: List<TreeState> by viewModel.treesState.collectAsState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = modifier.fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            TreeCards(trees = trees, { id -> viewModel.selectTree(id) })
        }
    }
}

@Preview
@Composable
fun InventoryScreenPreview() {
    InventoryScreen()
}