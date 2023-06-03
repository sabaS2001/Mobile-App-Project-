package com.example.project2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ComponentActivity

@SuppressLint("RestrictedApi")
class MainActivity : ComponentActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val introbutton : Button = findViewById(R.id.ViewButton)

        introbutton.setOnClickListener{
            val intent =  Intent(this, Options:: class.java);
            startActivity(intent)
        }

    }
}

