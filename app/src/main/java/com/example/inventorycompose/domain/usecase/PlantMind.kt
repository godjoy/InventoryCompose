package com.example.inventorycompose.domain.usecase

import com.example.inventorycompose.domain.model.Mind
import com.example.inventorycompose.domain.repository.GardenRepository
import javax.inject.Inject

class PlantMind @Inject constructor(private val gardenRepository: GardenRepository) {
    suspend operator fun invoke(mind: Mind) = gardenRepository.plantMind(mind)
}