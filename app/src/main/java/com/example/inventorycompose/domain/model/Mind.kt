package com.example.inventorycompose.domain.model

// mind + mind +... = garden
data class Mind(
    val id: Long,
    val treeId: Int,
    val location: Int
    // date 데이터는 생략
)