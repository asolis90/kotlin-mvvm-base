package com.asolis.kotlinmvvmbase.data.utils

/**
 * Created by angelsolis on 12/13/20.
 */
interface ModelTypeProvider {
    abstract fun getModelType(): Int
    abstract fun getModelClass(): Class<*>

    companion object {
        val MAIN = 1
    }
}