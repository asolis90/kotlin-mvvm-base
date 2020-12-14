package com.asolis.smartplanter.data.networking

import android.content.Context
import com.asolis.smartplanter.data.networking.ApiConfigurations
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class ApiBuilder(private val context: Context, private val apiConfigurations: ApiConfigurations) {
    fun <T> buildApi(baseURL : String?, tClass: Class<T>) : T {
        var retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                .client(apiConfigurations.getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(tClass)
    }

    companion object Factory {
    }
}