package com.asolis.kotlinmvvmbase.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.asolis.kotlinmvvmbase.R
import com.asolis.kotlinmvvmbase.data.models.CurrentWeather
import com.asolis.kotlinmvvmbase.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_second.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : BaseFragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun updateWeather(data: CurrentWeather?) {
        Timber.d("updateWeather")
        data?.weather?.let {
            textview_second.text = it[0].description
        }
    }
}