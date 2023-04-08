package com.khalbro.weatherapp

import android.app.Application
import android.content.Intent

const val APP_SETTINGS = "App settings"
const val IF_STARTED_UP = "Is started up"

class App : Application() {

    //TODO переменная БД
    override fun onCreate() {
        super.onCreate()

        //TODO инициализация БД
        val preferences = getSharedPreferences(APP_SETTINGS, MODE_PRIVATE)

        val flag = preferences.contains(IF_STARTED_UP)

        if (!flag) {
            val editor = preferences.edit()
            editor.putBoolean(IF_STARTED_UP, true)
            editor.apply()
            val intent = Intent(this, InitialActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}