package com.example.inventorycompose.ui.model

data class GardenItem(
    val treeId: Int? = null,
    val location: Int,
    val type: GardenType
)

enum class GardenType {
    Lake,
    Planted,
    Selected,
    Empty
}

val defaultGarden = (1..36).map { i ->
    when (i) {
        15, 16, 21, 22 -> GardenItem(location = i, type = GardenType.Lake)
        else -> GardenItem(location = i, type = GardenType.Empty)
    }
}.toList()