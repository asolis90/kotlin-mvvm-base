package com.asolis.kotlinmvvmbase.ui

open class Event {

    private var hasNotBeenHandled = true

    fun doIfNotHandled(block: () -> Unit) {
        if (hasNotBeenHandled) {
            hasNotBeenHandled = false
            block()
        }
    }
}