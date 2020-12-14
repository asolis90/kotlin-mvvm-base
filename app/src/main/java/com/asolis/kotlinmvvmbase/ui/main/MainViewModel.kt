package com.asolis.kotlinmvvmbase.ui.main

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.asolis.kotlinmvvmbase.data.models.CurrentWeather
import com.asolis.kotlinmvvmbase.data.repository.DataRepositoryImpl
import com.asolis.kotlinmvvmbase.ui.SafeMediatorLiveData
import com.asolis.kotlinmvvmbase.ui.Status
import com.asolis.kotlinmvvmbase.ui.ViewState
import com.asolis.kotlinmvvmbase.ui.base.BaseViewModel
import com.google.gson.JsonParser
import io.particle.android.sdk.cloud.ParticleDevice
import timber.log.Timber
import java.net.URL

class MainViewModel(
        private val repository: DataRepositoryImpl
) : BaseViewModel(repository) {
    private val currentWeatherState = SafeMediatorLiveData(initialValue = ViewState<CurrentWeather?>())

    fun currentWeatherState(): SafeMediatorLiveData<CurrentWeather?> = currentWeatherState

    fun getCurrentWeather() {
        viewModelScope.launch(
                block = {
                    val data = repository.getCurrentWeather()
                    currentWeatherState.update(status = Status.SUCCESS, data = data, isLoading = false)
                },
                exceptionHandler = {
                    handleFailure(currentWeatherState, it)
                }
        )
    }
}