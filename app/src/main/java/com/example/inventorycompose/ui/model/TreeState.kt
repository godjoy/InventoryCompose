package com.example.inventorycompose.ui.model

data class TreeState(
    val id: Int,
    var isSelected: Boolean
)


val mockTreeList = listOf<TreeState>(
    TreeState(1, false),
    TreeState(2, false),
    TreeState(3, false),
    TreeState(4, false),
    TreeState(5, false),
    TreeState(6, false),
    TreeState(7, false),
    TreeState(8, false),
    TreeState(9, false),
    TreeState(10,false),
    TreeState(11,false),
    TreeState(12,false),
    TreeState(13,false),
    TreeState(14,false),
    TreeState(15,false),
    TreeState(16,false)
)

val mockTreeState = TreeState(1, false)