package com.github.bleszerd.customcomponents

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
import com.github.bleszerd.customcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            binding.btn.setLoading()

            Handler(mainLooper).postDelayed({
                binding.btn.setEnable()
            }, 2000)
        }

        binding.swap.setAddClickListener {
            println("Adding")
        }

        binding.swap.setDeleteClickListener {
            println("Deleting")
        }
    }

}