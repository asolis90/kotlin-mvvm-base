package com.asolis.kotlinmvvmbase.data.repository

import android.content.Context
import com.asolis.kotlinmvvmbase.data.models.CurrentWeather
import com.asolis.kotlinmvvmbase.data.networking.domain.WeatherApi

class DataRepositoryImpl(
    val context: Context,
    val restApi: WeatherApi
) : DataRepository {
    init {
    }

    /**
     * NETWORK CALLS
     */

    override suspend fun getCurrentWeather(zipcode: String): CurrentWeather? {
        return restApi.weatherByZipCode(
            WeatherApi.VERSION,
            zipcode,
            WeatherApi.APP_ID
        ).body()
    }
}