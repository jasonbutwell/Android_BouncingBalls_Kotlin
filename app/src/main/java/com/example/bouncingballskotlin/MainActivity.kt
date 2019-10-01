package com.example.bouncingballskotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bouncingBallView = BouncingBallView(this)
        setContentView(bouncingBallView)
        bouncingBallView.setBackgroundColor(Color.BLACK)

        //setContentView(R.layout.activity_main)
    }
}
