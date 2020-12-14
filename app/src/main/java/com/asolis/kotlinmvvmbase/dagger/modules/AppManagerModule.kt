package com.asolis.kotlinmvvmbase.dagger.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppManagerModule(val context: Context) {

    // Context
    @Provides
    @Singleton
    open fun providesContext() : Context {
        return context
    }
}