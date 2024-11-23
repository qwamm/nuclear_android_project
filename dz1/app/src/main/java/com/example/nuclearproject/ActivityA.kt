package com.example.nuclearproject

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity


class ActivityA : FragmentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        Log.d("TAG", "A - $taskId")
    }

    fun onClicActivityB(v: View) {
        val intent = Intent(this, ActivityB::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(intent)
    }

    fun onClickFragmentB(v: View)
    {
        val fragmentManager = this@ActivityA.supportFragmentManager
        val orientation = resources.configuration.orientation
        val transaction = this.supportFragmentManager.beginTransaction()
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            val fragment = FragmentBA()
            transaction.add(R.id.fragment_ba, fragment)
            transaction.addToBackStack(null)
            transaction.show(fragment)
            transaction.commit()
        }
        else {
            val fragment = FragmentBB()
            transaction.add(R.id.fragment_bb, fragment)
            transaction.addToBackStack(null)
            transaction.show(fragment)
            transaction.commit()
        }
    }

    fun onClickFragmentBB(v: View)
    {
        val transaction = this.supportFragmentManager.beginTransaction()
        val fragment = FragmentBB()
        transaction.add(R.id.fragment_bb, fragment)
        transaction.addToBackStack(null)
        transaction.show(fragment)
        transaction.commit()
    }

    override fun onSaveInstanceState(outState: Bundle) { // Here You have to save count value
        outState.putString("ID", "My String")
        super.onSaveInstanceState(outState)
    }

}