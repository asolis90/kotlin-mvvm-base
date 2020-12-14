package com.asolis.kotlinmvvmbase.ui

data class ViewError(val errorType: ErrorType, val error: Throwable) : Event()

enum class ErrorType {
    HTTP_ERROR,
    CONNECTION_ERROR,
    UNKNOWN_ERROR
}