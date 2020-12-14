package com.asolis.kotlinmvvmbase.dagger.components

import com.asolis.kotlinmvvmbase.application.MyApplication
import com.asolis.kotlinmvvmbase.ui.main.MainActivity
import com.asolis.kotlinmvvmbase.dagger.modules.AppManagerModule
import com.asolis.kotlinmvvmbase.dagger.modules.UIModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppManagerModule::class, UIModule::class])
interface AppComponent {

    // Application
    fun inject(myApplication: MyApplication)

    // Activities
    fun inject(mainActivity: MainActivity)
}