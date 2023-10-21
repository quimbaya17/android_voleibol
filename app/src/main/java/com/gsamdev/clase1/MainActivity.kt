package com.gsamdev.clase1

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var usuario = ""
    private var contrasenia = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        initUI()

    }
    //Inicializamos el diseño
    private fun initUI() {
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnIngresar.setOnClickListener {
            usuario = binding.txtUsuario.text.toString()
            //Intencion de pasar de una actividad a otra

            if (validateForm()) {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("nombreUsuario", usuario)
                startActivity(intent)
            }
        }
    }

    //Validamos el formulario
    private fun validateForm(): Boolean {
        return if (binding.txtUsuario.text.toString().isEmpty()) {
            Toast.makeText(this, "Por favor dijite su usuario", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

}