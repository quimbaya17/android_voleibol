package com.gsamdev.clase1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    private var nombreUsuario = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setupGetExtras()
    }

    private fun setupGetExtras() {
        //Obtenemos los valores pasados de la anterior pantalla
        nombreUsuario = intent.getStringExtra("nombreUsuario").toString()
        binding.txtUsuario.text = nombreUsuario
    }
}