package com.mor.peppereview.framework.presentation

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mor.peppereview.R
import com.mor.peppereview.buisness.domain.models.Domain
import com.mor.peppereview.buisness.domain.state.DataState
import com.mor.peppereview.framework.util.Constants.Companion.API_KEY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment
constructor(
    private val someString: String
) : Fragment(R.layout.fragment_home) {

    private val TAG: String = "AppDebug"

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var location: Location

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())



        subscribeObservers()
        getClientLocation()

        location.let {
            viewModel.setStateEvent(
                MainStateEvent.GetWeatherEvent(
                    lat = it.latitude,
                    lon = it.longitude,
                    citiesAmount = 25,
                    apiKey = API_KEY
                )
            )
        }


        Log.d(TAG, "someString: ${someString}")
    }

    private fun getClientLocation() {
        val task = fusedLocationClient.lastLocation

        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                101
            )
            return
        }

        task.addOnSuccessListener {
            if (it != null) {
                this.location = it
                Toast.makeText(
                    requireContext(),
                    "${it.latitude} ${it.longitude}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }


    private fun subscribeObservers() {
        viewModel.dataState.observe(viewLifecycleOwner, Observer { dataState ->
            when (dataState) {
                is DataState.Success<List<Domain>> -> {
                    displayProgressBar(false)
                    setUI(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message != null) text.text = message else text.text = "Unknown error."
    }

    private fun setUI(domainList: List<Domain>) {

    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}