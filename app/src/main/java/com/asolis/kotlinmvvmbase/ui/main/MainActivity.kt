package com.asolis.kotlinmvvmbase.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.asolis.kotlinmvvmbase.R
import com.asolis.kotlinmvvmbase.dagger.components.AppComponent
import com.asolis.kotlinmvvmbase.ui.Status
import com.asolis.kotlinmvvmbase.ui.base.BaseActivity
import com.asolis.kotlinmvvmbase.ui.base.BaseFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.asolis.kotlinmvvmbase.ui.main.MainViewModel
import kotlinx.android.synthetic.main.content_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject
    internal lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        observe();

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Test", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            getViewModel().getCurrentWeather()
        }
    }

    private fun observe() {
        getViewModel().currentWeatherState()
            .observe(this, androidx.lifecycle.Observer { viewState ->
                when (viewState.status) {
                    Status.LOADING -> {
                    }
                    Status.SUCCESS -> {

                        val fragment =
                            nav_host_fragment.childFragmentManager.fragments[0]
                        when (fragment) {
                            is SecondFragment,
                            is FirstFragment -> {
                                (fragment  as BaseFragment?)?.updateWeather(viewState.data)
                            }
                        }
                    }
                    Status.ERROR -> {
                    }
                }
            })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, factory)[MainViewModel::class.java]
    }

    override fun injectSelf(appComponent: AppComponent) {
        appComponent.inject(this)
    }
}