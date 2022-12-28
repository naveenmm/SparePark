 package com.example.sparepark.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sparepark.R
import com.example.sparepark.database.RoomDB
import com.example.sparepark.database.SpaceFinderRaw
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}