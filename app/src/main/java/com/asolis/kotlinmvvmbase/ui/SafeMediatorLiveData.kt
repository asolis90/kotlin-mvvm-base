package com.asolis.kotlinmvvmbase.ui

import androidx.lifecycle.MediatorLiveData

/**
 * A safer [MediatorLiveData] that has an initial value and doesn't accept nor expose nullables.
 */
class SafeMediatorLiveData<T>(initialValue: ViewState<T>) : MediatorLiveData<ViewState<T>>() {

    init {
        value = initialValue
    }

    override fun getValue(): ViewState<T> = super.getValue()!!

    fun update(
            data: T? = value.data,
            status: Status = value.status,
            isLoading: Boolean = value.isLoading,
            total_count: Int = value.total_count,
            error: ViewError? = value.error
    ) {
        value = value.copy(status = status, data = data, isLoading = isLoading, total_count = total_count, error = error)
    }
}