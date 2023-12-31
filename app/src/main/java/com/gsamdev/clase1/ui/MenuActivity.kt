package com.gsamdev.clase1.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.data.prefs.SharedPreferencesManager
import com.gsamdev.clase1.databinding.ActivityMenuBinding
import com.gsamdev.clase1.ui.game.TeamPlanningActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private lateinit var sharedPref: SharedPreferencesManager

    private var nombreUsuario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)

        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setupGetExtras()
        setupGetPrefs()
        setupClickListeners()
    }

    private fun setupClickListeners() {

        binding.btnNewGame.setOnClickListener {
            val intent = Intent(this, TeamPlanningActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupGetPrefs() {
        nombreUsuario = sharedPref.getPref("userNameKey", "Empty").toString()
        binding.txtUsuario.text = nombreUsuario
    }

    private fun setupGetExtras() {
        nombreUsuario = intent.getStringExtra("nombreUsuario").toString()
        binding.txtUsuario.text = nombreUsuario
    }
}