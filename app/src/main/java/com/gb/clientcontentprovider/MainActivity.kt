package com.gb.clientcontentprovider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.insert).setOnClickListener{
HistorySource(contentResolver).insert(HistorySource.HistoryWeatherEntity(7,"HamBurg", 9))
        }

    }
}