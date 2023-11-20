package com.example.workauth.presentation.auth

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.workauth.R
import com.example.workauth.databinding.ActivityMainBinding
import com.example.workauth.presentation.auth.fragment.WriteNumberPhoneFragment

class MainActivity: AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        if (savedInstanceState == null){
            val fragment = WriteNumberPhoneFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_ViewID, fragment)
                .addToBackStack(null)
                .commit()
        }
    }
}