package com.example.inventorycompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.inventorycompose.domain.usecase.GetTrees
import com.example.inventorycompose.ui.model.TreeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class InventoryViewModel @Inject constructor(
    private val getTreesUseCase: GetTrees
) : ViewModel() {
    private val _treesState = MutableStateFlow<List<TreeState>>(emptyList())
    val treesState: StateFlow<List<TreeState>> = _treesState.asStateFlow()

    init {
        initTrees()
    }

    private fun initTrees() {
        _treesState.value = getTreesUseCase.invoke().mapIndexed { index, i ->
            if (index == 0) TreeState(i, true)
            else TreeState(i, false)
        }.toList()
    }

    // single selection
    fun selectTree(newSelectedId: Int) {
        _treesState.value = _treesState.value.map { treeState ->
            if (treeState.id == newSelectedId)
                treeState.copy(isSelected = true)
            else treeState.copy(isSelected = false)
        }
    }
}