package com.asolis.kotlinmvvmbase.ui.base

import androidx.lifecycle.ViewModel
import com.asolis.kotlinmvvmbase.data.repository.DataRepositoryImpl
import com.asolis.kotlinmvvmbase.ui.ErrorType
import com.asolis.kotlinmvvmbase.ui.SafeMediatorLiveData
import com.asolis.kotlinmvvmbase.ui.Status
import com.asolis.kotlinmvvmbase.ui.ViewError
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

open class BaseViewModel(
        private val repository: DataRepositoryImpl
) : ViewModel() {

    fun <T> handleFailure(state: SafeMediatorLiveData<T>, throwable: Throwable) {
        Timber.e(throwable.message)
        val type: ErrorType = when (throwable) {
            is HttpException -> ErrorType.HTTP_ERROR
            is IOException -> ErrorType.CONNECTION_ERROR
            else -> ErrorType.UNKNOWN_ERROR
        }
        state.update(status = Status.ERROR, isLoading = false, error = ViewError(type, throwable))
    }

    // avoids CancellationException
    inline fun CoroutineScope.launch(
            noinline block: suspend CoroutineScope.() -> Unit,
            crossinline exceptionHandler: (Throwable) -> Unit
    ) {
        launch(CoroutineExceptionHandler { _, throwable -> exceptionHandler(throwable) }, block = block)
    }
}