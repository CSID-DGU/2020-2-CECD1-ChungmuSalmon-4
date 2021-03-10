package com.chungmusalmon.hangangreporter.ui

import android.os.Bundle
import com.chungmusalmon.hangangreporter.R
import com.chungmusalmon.hangangreporter.base.BaseActivity
import com.chungmusalmon.hangangreporter.databinding.ActivityMainBinding
import com.chungmusalmon.hangangreporter.viewmodel.MainViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), OnMapReadyCallback{
    override val layoutRes: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.apply {
            val sydney = LatLng(-33.852, 151.211)
            addMarker(
                MarkerOptions()
                    .position(sydney)
                    .title("Marker in Sydney")
            )
            // [START_EXCLUDE silent]
            moveCamera(CameraUpdateFactory.newLatLng(sydney))
            // [END_EXCLUDE]
        }
    }
}