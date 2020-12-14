package com.asolis.kotlinmvvmbase.application

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.asolis.kotlinmvvmbase.dagger.components.AppComponent
import com.asolis.kotlinmvvmbase.dagger.components.DaggerAppComponent
import com.asolis.kotlinmvvmbase.dagger.modules.AppManagerModule
import com.asolis.kotlinmvvmbase.dagger.modules.UIModule
import io.particle.android.sdk.cloud.ParticleCloudSDK
import timber.log.Timber

class MyApplication : MultiDexApplication() {
    companion object {
        private lateinit var context: Context
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        buildComponent()
        appComponent.inject(this)
        Timber.plant(Timber.DebugTree());
    }

    private fun buildComponent() {
        appComponent = DaggerAppComponent.builder()
            .appManagerModule(AppManagerModule(context))
            .uIModule(UIModule(context))
            .build()
    }
}