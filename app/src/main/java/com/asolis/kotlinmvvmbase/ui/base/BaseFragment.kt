package com.asolis.kotlinmvvmbase.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.asolis.kotlinmvvmbase.ui.ActivityListener

abstract class BaseFragment : Fragment(), ActivityListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}