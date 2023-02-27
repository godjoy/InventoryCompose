package com.example.inventorycompose.data

import com.example.inventorycompose.domain.repository.TreeRepository

class MockTreeRepositoryImpl: TreeRepository {
    override fun getTreesId(): List<Int> {
        return (1..16).toList()
    }
}