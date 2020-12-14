package com.asolis.kotlinmvvmbase.data.models

import android.os.Bundle
import android.os.Parcelable
import com.asolis.kotlinmvvmbase.data.models.BaseModel.BaseModel
import com.asolis.kotlinmvvmbase.data.utils.ModelTypeProvider
import kotlinx.android.parcel.Parcelize

/**
 * Created by angelsolis on 12/13/20.
 */
@Parcelize
data class CurrentWeather(
    val coord: Coordinates,
    val weather: ArrayList<Weather>,
    val main: Main,
    val icon: String, 
    override var actionType: String, 
    override var displayData: Bundle
) : BaseModel(), Parcelable {
    override fun getModelType(): Int {
        return ModelTypeProvider.MAIN
    }

    override fun getModelClass(): Class<*> {
        return CurrentWeather::class.java
    }

    override fun describeContents(): Int {
        return 0
    }
}

@Parcelize
data class Weather(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
) : Parcelable

@Parcelize
data class Coordinates(
    val lon: String,
    val lat: String
) : Parcelable

@Parcelize
data class Main(
    val temp: String,
    val pressure: String,
    val humidity: String,
    val temp_min: String,
    val temp_max: String
) : Parcelable

