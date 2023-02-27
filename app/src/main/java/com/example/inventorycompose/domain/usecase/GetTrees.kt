package com.example.inventorycompose.domain.usecase

import com.example.inventorycompose.domain.repository.TreeRepository
import javax.inject.Inject

class GetTrees @Inject constructor(private val treeRepository: TreeRepository) {
    operator fun invoke() = treeRepository.getTreesId()
}