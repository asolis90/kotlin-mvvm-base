package com.asolis.kotlinmvvmbase.ui

data class ViewState<T>(
        val status: Status = Status.LOADING,
        val data: T? = null,
        val isLoading: Boolean = false,
        val total_count: Int = 0,
        val error: ViewError? = null
)

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}