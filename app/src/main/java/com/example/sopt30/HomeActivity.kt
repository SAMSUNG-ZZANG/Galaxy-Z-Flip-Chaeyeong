package com.example.sopt30

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt30.databinding.ActivityHomeBinding
import com.example.sopt30.databinding.ActivitySignInBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_home)
    }
}