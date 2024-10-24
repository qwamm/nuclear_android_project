package com.example.nuclearproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity


class ActivityA : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
    }

    fun onClicActivityB(v: View) {
        val intent = Intent(this, ActivityB::class.java)
        startActivity(intent)
    }

    fun onClickFragmentB(v: View)
    {

    }

}