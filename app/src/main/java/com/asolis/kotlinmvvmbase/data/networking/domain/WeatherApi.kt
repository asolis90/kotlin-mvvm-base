package com.asolis.kotlinmvvmbase.data.networking.domain

import com.asolis.kotlinmvvmbase.data.models.CurrentWeather
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by angelsolis on 12/13/20.
 */
interface WeatherApi {

    @GET("/data/{version}/weather")
    suspend fun weatherByZipCode(
        @Path("version") version: String,
        @Query("zip") zipcode: String,
        @Query("appid") appId: String
    ): Response<CurrentWeather>

    companion object Factory {
        var BASE_URL: String = "https://api.openweathermap.org/"
        var VERSION : String = "2.5"
        var APP_ID: String = "<OPEN_WEATHER_MAP_API_KEY>"
        val HTTP_CACHE_FILENAME = "WeatherApiHttpCache"
    }
}