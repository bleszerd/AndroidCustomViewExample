package com.github.bleszerd.customcomponents

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.github.bleszerd.customcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.btn.setLoading()

            Handler(mainLooper).postDelayed({
                println("Login success")
                binding.btn.setEnable()
            }, 2000)
        }
    }
}