package com.example.nuclearproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class ActivityB : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
    }

    fun onClicActivityC(v: View) {
        val intent = Intent(this, ActivityC::class.java)
        startActivity(intent)
    }


}