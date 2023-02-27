package com.example.inventorycompose.di

import com.example.inventorycompose.data.MockGardenRepositoryImpl
import com.example.inventorycompose.data.MockTreeRepositoryImpl
import com.example.inventorycompose.domain.repository.GardenRepository
import com.example.inventorycompose.domain.repository.TreeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    fun provideTreeRepository(): TreeRepository {
        return MockTreeRepositoryImpl()
    }

    @Provides
    fun provideGardenRepository(): GardenRepository {
        return MockGardenRepositoryImpl()
    }
}