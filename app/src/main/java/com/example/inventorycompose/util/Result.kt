package com.example.inventorycompose.util

sealed class Result<out R>() {
    object Loading: Result<Nothing>()
    data class Success<out T>(val data: T?) : Result<T>()
    data class Failure(val e: Exception?): Result<Nothing>()
}