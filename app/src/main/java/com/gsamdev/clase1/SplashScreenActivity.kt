package com.gsamdev.clase1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import com.gsamdev.clase1.data.SharedPreferencesManager
import com.gsamdev.clase1.databinding.ActivitySplashScreenBinding
import com.gsamdev.clase1.ui.MainActivity
import com.gsamdev.clase1.ui.MenuActivity

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private lateinit var sharedPref: SharedPreferencesManager
    private val timeSplash = 3000L
    private var userIsLogged = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI() {
        setupJumpNextActivity()
        setupGetPrefs()
    }

    private fun setupGetPrefs() {
        userIsLogged = sharedPref.getPref("userIsLoggedKey", false) as Boolean
    }

    private fun setupJumpNextActivity() =
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                if (userIsLogged) {
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }, timeSplash)
        }
}