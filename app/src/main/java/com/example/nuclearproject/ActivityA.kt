package com.example.nuclearproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity


class ActivityA : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val prev = savedInstanceState?.getString("ID")
        setContentView(R.layout.main)
    }

    fun onClicActivityB(v: View) {
        val intent = Intent(this, ActivityB::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    fun onClickFragmentB(v: View)
    {

    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        outState.putString("ID", "My String")
        super.onSaveInstanceState(outState)
    }

}