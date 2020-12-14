package com.asolis.kotlinmvvmbase.ui

import com.asolis.kotlinmvvmbase.data.models.CurrentWeather

interface ActivityListener {
    fun updateWeather(data : CurrentWeather?)
}