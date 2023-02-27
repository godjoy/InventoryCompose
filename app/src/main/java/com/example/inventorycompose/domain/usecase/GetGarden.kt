package com.example.inventorycompose.domain.usecase

import com.example.inventorycompose.domain.repository.GardenRepository
import javax.inject.Inject

class GetGarden @Inject constructor(private val gardenRepository: GardenRepository) {
    operator fun invoke() = gardenRepository.getGarden()
}