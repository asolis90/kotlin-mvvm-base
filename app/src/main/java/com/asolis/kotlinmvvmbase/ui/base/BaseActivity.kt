package com.asolis.kotlinmvvmbase.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.asolis.kotlinmvvmbase.application.MyApplication
import com.asolis.kotlinmvvmbase.dagger.components.AppComponent

abstract class BaseActivity<T : ViewModel> : AppCompatActivity() {
    private lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectSelf(MyApplication.appComponent)
        this.viewModel = getViewModel()
    }

    abstract fun getViewModel(): T

    abstract fun injectSelf(appComponent: AppComponent)
}