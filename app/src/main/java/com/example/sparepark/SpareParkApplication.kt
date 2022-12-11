package com.example.sparepark

import android.app.Application

class SpareParkApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: Application
            private set
    }
}