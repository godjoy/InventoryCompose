package com.example.inventorycompose.ui.util

sealed class UIState<out T> {
    data class Success<out T>(
        val data: T
    ): UIState<T>()
    object Error: UIState<Nothing>()
    object Loading: UIState<Nothing>()
}