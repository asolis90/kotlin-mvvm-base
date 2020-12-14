package com.asolis.kotlinmvvmbase.data.repository

import com.asolis.kotlinmvvmbase.data.models.CurrentWeather

interface DataRepository {

    /**
     * DATABASE CALLS
     */


    /**
     * API CALLS
     */
    suspend fun getCurrentWeather(zip: String = "11201,us"): CurrentWeather?
}