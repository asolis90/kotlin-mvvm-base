package com.asolis.kotlinmvvmbase.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.asolis.kotlinmvvmbase.data.repository.DataRepositoryImpl
import com.asolis.kotlinmvvmbase.ui.main.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
        private val repository: DataRepositoryImpl
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}