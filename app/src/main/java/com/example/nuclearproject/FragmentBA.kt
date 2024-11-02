package com.example.nuclearproject

import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.compose.ui.graphics.Color
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener

class FragmentBA: Fragment(R.layout.fragment_ba)
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val result = bundle.getInt("color")
            if (result != null) {
                val num = (0..10).random()
                Log.d("TAG", result.toString())
                this.view?.setBackgroundColor(result)
            }
            else {
                Log.d("TAG", "NULLABLE color")
            }
        }
    }
}