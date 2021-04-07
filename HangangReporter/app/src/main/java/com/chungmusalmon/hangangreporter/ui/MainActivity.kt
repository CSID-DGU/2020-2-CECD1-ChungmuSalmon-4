package com.chungmusalmon.hangangreporter.ui

import android.os.Bundle
import android.util.Log
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
import androidx.lifecycle.observe
import com.chungmusalmon.hangangreporter.ui.adapter.SectionAdapter

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), OnMapReadyCallback{
    override val layoutRes: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModel()

    private val adapter = SectionAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        initView()
        initObserver()
    }

    private fun initView(){
        viewModel.loadLocate()
        val mapFragment =
            supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        binding.rvSection.adapter = adapter
    }

    private fun initObserver(){
        viewModel.state().locate.observe(this) {
            adapter.addItems(it)
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.apply {
            viewModel.state().locate.observe(this@MainActivity) {
                var test : LatLng = initLatLng
                for(section in it){
                    test = LatLng(section.longitude, section.latitude)
                    addMarker(
                        MarkerOptions()
                            .position(test)
                            .title(section.name)
                    )
                }
                moveCamera(CameraUpdateFactory.newLatLngZoom(test, zoomLevel))
            }
        }
    }

    companion object{
        private const val defaultLng = 35.0
        private const val defaultLat = 127.0
        val initLatLng = LatLng(defaultLng, defaultLat)
        const val zoomLevel = 15F
    }
}