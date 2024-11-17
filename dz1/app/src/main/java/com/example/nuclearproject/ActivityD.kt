package com.example.nuclearproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

interface FragmentResultOwner
{
    fun setFragmentResult(requestKey: String, result: Bundle)
    fun clearFragmentResult(requestKey: String)
    fun setFragmentResultListener(
        requestKey: String,
        lifecycle: LifecycleOwner,
        listener: FragmentResultListener
        )
    fun clearFragmentResultListener(requestKey: String)
}

class ActivityD : FragmentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        Log.d("TAG", "D - $taskId")
    }

    fun onClickFragmentBB (v: View)
    {
        val fragment = FragmentBB()
        val fragmentManager = this@ActivityD.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_ba, fragment)
        transaction.addToBackStack(null)
        transaction.show(fragment)
        transaction.commit()
    }

    fun onClickSendColor (v: View)
    {
        val fragment = FragmentBA()
        val fragmentManager = this@ActivityD.supportFragmentManager
        val prev = fragmentManager.findFragmentById(R.id.fragment_bb)
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_ba, fragment)
        transaction.addToBackStack(null)
        transaction.show(fragment)
        transaction.commit()
    }

}