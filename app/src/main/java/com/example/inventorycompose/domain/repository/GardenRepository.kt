package com.example.inventorycompose.domain.repository

import com.example.inventorycompose.domain.model.Mind
import com.example.inventorycompose.util.Result
import kotlinx.coroutines.flow.Flow


interface GardenRepository {
    fun getGarden(): Flow<Result<List<Mind>>>
}