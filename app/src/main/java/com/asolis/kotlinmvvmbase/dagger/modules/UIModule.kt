package com.asolis.kotlinmvvmbase.dagger.modules

import android.content.Context
import com.asolis.kotlinmvvmbase.data.networking.domain.WeatherApi
import com.asolis.kotlinmvvmbase.data.repository.DataRepositoryImpl
import com.asolis.kotlinmvvmbase.ui.main.MainViewModelFactory
import com.asolis.smartplanter.data.networking.ApiBuilder
import com.asolis.smartplanter.data.networking.ApiConfigurations
import dagger.Module
import dagger.Provides
import okhttp3.*
import java.io.File
import javax.inject.Singleton

@Module
open class UIModule(val context: Context) {

    @Provides
    open fun providesMainViewModelFactory(repository: DataRepositoryImpl): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }

    @Singleton
    @Provides
    fun providesRepository(
            context: Context
    ): DataRepositoryImpl {
        // cache size of 10MB
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(File(context.cacheDir, WeatherApi.HTTP_CACHE_FILENAME), cacheSize.toLong())
        var apiBaseUrl: String? = WeatherApi.BASE_URL

        return DataRepositoryImpl(
                context,
                ApiBuilder(context, ApiConfigurations(cache, Interceptor { it ->
                    val request = it.request()
                    // handle auth if needed..
                    it.proceed(request)

                })).buildApi(apiBaseUrl, WeatherApi::class.java))
    }
}