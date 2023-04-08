package com.khalbro.weatherapp

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.*
import com.khalbro.weatherapp.view.adapters.MainDailyListAdapter
import com.khalbro.weatherapp.view.adapters.MainHourlyListAdapter
import kotlinx.android.synthetic.main.activity_main.*


const val TAG = "GEO_TEST"

class MainActivity : AppCompatActivity() {

    private val geoService by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private val locationRequest by lazy { initLocationRequest() }
    private lateinit var mLocation: Location

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        main_hourly_list.apply {
            adapter = MainHourlyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
        }

        main_daily_list.apply {
            adapter = MainDailyListAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }

        geoService.requestLocationUpdates(locationRequest, geoCallback, null)
    }

    private fun initViews() {
        tv_main_city_name.text = "Krasnodar"
        tv_main_data.text = "16 april"
        tv_main_temp.text = "25\u00B0"
        tv_main_cloudy.text = "cloudy"
        tv_main_min_temp.text = "11"
        tv_main_med_temp.text = "20"
        tv_main_max_temp.text = "26"
        iv_main_weather.setImageResource(R.mipmap.cloud_draw_xxxhi)
        tv_wind_speed.text = "4 м/с"
        tv_air_humidity.text = "78%"
        tv_sunrise.text = "5:58"
        tv_sunset.text = "20:12"
    }

    //--------------Location code--------------
    private fun initLocationRequest(): LocationRequest {
        return LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000)
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(5000)
            .setMaxUpdateAgeMillis(10000)
            .build()
    }

    private val geoCallback = object : LocationCallback() {
        override fun onLocationResult(geo: LocationResult) {
            Log.d(TAG, "onLocationResult: ${geo.locations.size}")
            for (location in geo.locations) {
                mLocation = location
                Log.d(
                    TAG,
                    "onLocationResult: lat: ${location.latitude}; lon: ${location.longitude}"
                )
            }
        }
    }
}