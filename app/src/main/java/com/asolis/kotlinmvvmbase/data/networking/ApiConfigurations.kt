package com.asolis.smartplanter.data.networking

import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class ApiConfigurations(private val cache: Cache?, private var interceptor: Interceptor) {
    fun getClient() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(logging)
        if(cache != null) {
            builder.cache(cache)
        }
        return builder.build()
    }
}
