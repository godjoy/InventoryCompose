package com.example.inventorycompose.ui.model

data class TreeItem(
    val id: Int,
    var isSelected: Boolean
)

val mockTreeList = listOf<TreeItem>(
    TreeItem(1, false),
    TreeItem(2, false),
    TreeItem(3, false),
    TreeItem(4, false),
    TreeItem(5, false),
    TreeItem(6, false),
    TreeItem(7, false),
    TreeItem(8, false),
    TreeItem(9, false),
    TreeItem(10,false),
    TreeItem(11,false),
    TreeItem(12,false),
    TreeItem(13,false),
    TreeItem(14,false),
    TreeItem(15,false),
    TreeItem(16,false)
)

val mockTreeItem = TreeItem(1, false)