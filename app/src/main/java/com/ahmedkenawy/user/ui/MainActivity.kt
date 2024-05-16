package com.ahmedkenawy.user.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ahmedkenawy.footballleague.R
import com.ahmedkenawy.footballleague.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}