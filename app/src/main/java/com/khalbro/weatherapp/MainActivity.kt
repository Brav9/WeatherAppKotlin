package com.khalbro.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}