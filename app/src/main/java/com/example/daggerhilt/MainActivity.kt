package com.example.daggerhilt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.daggerhilt.vm.MainViewModel
import com.example.daggerhilt.vm.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            mainViewModel.flow.collect {
                when (it) {
                    is Resource.Failure -> {

                    }

                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        Log.d(TAG, "onCreate: ${it.data}")
                    }
                }
            }
        }


    }
}