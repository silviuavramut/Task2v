package com.example.task2v

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    private lateinit var foregroundChrono : Chronometer
    private lateinit var backgroundChrono : Chronometer
    private var secondsForegroundCounter : Long = 0
    private var secondsBackgroundCounter : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foregroundChrono = findViewById(R.id.fgChrono)
        backgroundChrono = findViewById(R.id.bgChrono)


    }
    override fun onResume() {
        super.onResume()
        backgroundChrono.stop()
        secondsBackgroundCounter = SystemClock.elapsedRealtime() - backgroundChrono.base
        backgroundChrono.base = SystemClock.elapsedRealtime() - secondsBackgroundCounter

        foregroundChrono.base = SystemClock.elapsedRealtime() - secondsForegroundCounter
        foregroundChrono.start()

    }

    override fun onPause() {
        super.onPause()
        foregroundChrono.stop()
        secondsForegroundCounter = SystemClock.elapsedRealtime() - foregroundChrono.base

        backgroundChrono.base = SystemClock.elapsedRealtime() - secondsBackgroundCounter
        backgroundChrono.start()

    }



}