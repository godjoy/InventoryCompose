package com.example.inventorycompose.ui.model

data class GardenState(
    val isLoading: Boolean,
    val selectedTreeId: Int = 1,
    val selectedLocation: Int = 6,
    val garden: List<GardenItem> = defaultGarden
)