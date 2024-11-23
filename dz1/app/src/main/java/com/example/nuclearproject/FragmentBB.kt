package com.example.nuclearproject

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class FragmentBB: Fragment(R.layout.fragment_bb)
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResult("requestKey", bundleOf("color" to (0..10).random()))
        Log.d("TAG", "SEND")
    }

}