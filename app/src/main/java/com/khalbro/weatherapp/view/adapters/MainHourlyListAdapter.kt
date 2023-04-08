package com.khalbro.weatherapp.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.textview.MaterialTextView
import com.khalbro.weatherapp.R
import com.khalbro.weatherapp.business.model.   HourlyWeatherModel

class MainHourlyListAdapter : BaseAdapter<HourlyWeatherModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_hourly, parent, false)
        return HourlyViewHolder(view)
    }

    inner class HourlyViewHolder(view: View) : BaseViewHolder(view) {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_item_hourly_time)
        lateinit var time: MaterialTextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_item_hourly_tepm)
        lateinit var temperature: MaterialTextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.iv_item_hourly_weather_condition_icon)
        lateinit var icon: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        override fun bindView(position: Int) {
            time.text = "14:00"
            temperature.text = "25°"
            icon.setImageResource(R.drawable.ic_sun)
            if(position==3){time.setTextColor(ContextCompat.getColor(time.context, R.color.red))}
        }
    }
}