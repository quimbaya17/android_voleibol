package com.gsamdev.clase1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.gsamdev.clase1.databinding.ActivitySplashScreenBinding
import com.gsamdev.clase1.ui.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val timeSplash = 3000L

    //Create variable for SharedPreferencesManger


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initUI()

        //Create function to validate if user is logged
        //Validate jump to next activity

    }

    private fun initUI() = setupJumpNextActivity()

    private fun setupJumpNextActivity() =
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, timeSplash)
        }
}