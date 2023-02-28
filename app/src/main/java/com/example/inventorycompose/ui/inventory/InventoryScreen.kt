package com.example.inventorycompose.ui.inventory

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.inventorycompose.ui.inventory.garden.GardenCards
import com.example.inventorycompose.ui.inventory.tree.TreeCards
import com.example.inventorycompose.ui.model.GardenState
import com.example.inventorycompose.ui.model.TreeItem
import com.example.inventorycompose.ui.viewmodel.InventoryViewModel

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun InventoryScreen(
    modifier: Modifier = Modifier,
    viewModel: InventoryViewModel = hiltViewModel()
) {
    val treeState: List<TreeItem> by viewModel.treeState.collectAsStateWithLifecycle()
    val gardenState: GardenState by viewModel.gardenState.collectAsStateWithLifecycle()
    val statusText by viewModel.statusText.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = statusText,
                modifier = modifier.padding(bottom = 15.dp),
                fontSize = 20.sp
            )
            GardenCards(
                garden = gardenState.garden,
                onSelect = { location -> viewModel.selectLocation(location) }
            )
        }
        Row(
            modifier = modifier.fillMaxHeight(),
            verticalAlignment = Alignment.Bottom
        ) {
            TreeCards(
                trees = treeState,
                onSelect = { id -> viewModel.selectTree(id) }
            )
        }
    }
}

@Preview
@Composable
fun InventoryScreenPreview() {
    InventoryScreen()
}