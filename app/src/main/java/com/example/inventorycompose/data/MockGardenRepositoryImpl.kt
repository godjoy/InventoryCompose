package com.example.inventorycompose.data

import com.example.inventorycompose.domain.model.Mind
import com.example.inventorycompose.domain.repository.GardenRepository
import com.example.inventorycompose.util.Result
import kotlinx.coroutines.flow.*

class MockGardenRepositoryImpl : GardenRepository {
    private var mockGarden = listOf<Mind>(
        Mind(5,1),
        Mind(6,5),
        Mind(11,32)
    )

    override fun getGarden(): Flow<Result<List<Mind>>> = flow {
        emit(Result.Loading)
        emit(Result.Success(mockGarden))
    }

}