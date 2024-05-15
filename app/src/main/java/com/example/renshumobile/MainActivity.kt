package com.example.renshumobile

import android.content.Intent
import  android.os.Bundle
import android.os.Handler


import androidx.appcompat.app.AppCompatActivity

import android.os.Looper

class MainActivity : AppCompatActivity() {
    private val splashtimeout: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity,LoginPage::class.java)
            startActivity(intent)
            finish()
        },splashtimeout)
    }
}