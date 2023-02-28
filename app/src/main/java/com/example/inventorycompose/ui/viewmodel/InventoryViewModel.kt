package com.example.inventorycompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorycompose.domain.model.Mind
import com.example.inventorycompose.domain.usecase.GetGarden
import com.example.inventorycompose.domain.usecase.GetTrees
import com.example.inventorycompose.ui.model.*
import com.example.inventorycompose.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val getTreesUseCase: GetTrees,
    private val getGardenUseCase: GetGarden
) : ViewModel() {
    private val selectedTree = MutableStateFlow(1)
    private var trees: List<TreeItem>
    private fun initTree() = getTreesUseCase.invoke().mapIndexed { index, i ->
        if (index == 0) TreeItem(i, true)
        else TreeItem(i, false)
    }.toList()

    private val _gardenState = MutableStateFlow<GardenState>(GardenState(isLoading = true))
    val gardenState = _gardenState.asStateFlow()

    private fun getMinds() = viewModelScope.launch {
        getGardenUseCase.invoke().collectLatest { result ->
            when (result) {
                is Result.Failure -> println("Error")
                Result.Loading -> _gardenState.update { it.copy(isLoading = true) }
                is Result.Success -> {
                    _gardenState.update {
                        println("show")
                        it.copy(garden = merge(result.data, it.garden))
                    }
                }
            }
        }
    }

    init {
        trees = initTree()
        getMinds()
        selectLocation(6)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val treeState: StateFlow<List<TreeItem>> = selectedTree.mapLatest { selectedId ->
        trees.map { tree ->
            if (tree.id == selectedId) tree.copy(isSelected = true)
            else tree.copy(isSelected = false)
        }.also { trees = it }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), trees)

    fun selectTree(newSelectedId: Int) {
        selectedTree.value = newSelectedId
        _gardenState.update { curState ->
            curState.copy(
                selectedTreeId = newSelectedId,
                garden = curState.garden.map { gardenItem ->
                    if (gardenItem.type == GardenType.Selected) gardenItem.copy(treeId = newSelectedId)
                    else gardenItem
                }
            )
        }
    }

    fun selectLocation(newLocation: Int) {
        _gardenState.update { curState ->
            curState.copy(
                selectedLocation = newLocation,
                garden = curState.garden.map { gardenItem ->
                    if (gardenItem.location == newLocation)
                        gardenItem.copy(
                            type = GardenType.Selected,
                            treeId = curState.selectedTreeId
                        )
                    else {
                        if (gardenItem.type == GardenType.Selected)
                            gardenItem.copy(type = GardenType.Empty, treeId = null)
                        else gardenItem
                    }
                }
            )
        }
    }

    private fun merge(minds: List<Mind>?, garden: List<GardenItem>): List<GardenItem> {
        return if (minds.isNullOrEmpty()) garden
        else garden.map { gardenItem ->
            val mind = minds.find { it.location == gardenItem.location }
            if (mind == null) gardenItem
            else gardenItem.copy(treeId = mind.treeId, type = GardenType.Planted)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    val statusText = _gardenState.mapLatest { currentState ->
        "[선택한 나무]: ${currentState.selectedTreeId} [선택한 위치]: ${currentState.selectedLocation}"
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), "")
}