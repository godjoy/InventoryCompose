package com.example.inventorycompose.data

import com.example.inventorycompose.domain.model.Mind
import com.example.inventorycompose.domain.repository.GardenRepository
import com.example.inventorycompose.util.Result
import kotlinx.coroutines.flow.Flow

class MockGardenRepositoryImpl : GardenRepository {
    override fun getGarden(): Flow<Result<List<Mind>>> {
        TODO("Not yet implemented")
    }

    override suspend fun plantMind(mind: Mind): Result<Long> {
        TODO("Not yet implemented")
    }

}