package com.khalbro.weatherapp.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.google.android.material.textview.MaterialTextView
import com.khalbro.weatherapp.R
import com.khalbro.weatherapp.business.model.DailyWeatherModel

class MainDailyListAdapter : BaseAdapter<DailyWeatherModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_daily, parent, false)
        return DailyViewHolder(view)
    }

    inner class DailyViewHolder(view: View) : BaseViewHolder(view) {

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_item_daily_date)
        lateinit var data: MaterialTextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_item_daily_max_temp)
        lateinit var maxTemp: MaterialTextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.tv_item_daily_min_temp)
        lateinit var minTemp: MaterialTextView

        @SuppressLint("NonConstantResourceId")
        @BindView(R.id.iv_item_daily_condition_icon)
        lateinit var icon: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }

        override fun bindView(position: Int) {
            data.text = "16 Sunday"
            maxTemp.text = "25°"
            minTemp.text = "18°"
            icon.setImageResource(R.drawable.ic_sun)
        }
    }
}