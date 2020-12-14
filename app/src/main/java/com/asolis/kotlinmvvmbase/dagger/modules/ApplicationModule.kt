package com.asolis.kotlinmvvmbase.dagger.modules

import com.asolis.kotlinmvvmbase.application.MyApplication
import com.asolis.kotlinmvvmbase.dagger.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplication(): MyApplication = this.application

}