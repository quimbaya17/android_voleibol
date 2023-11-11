package com.gsamdev.clase1.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.data.SharedPreferencesManager
import com.gsamdev.clase1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferencesManager

    private var usuario = ""
    private var contrasenia = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)
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
            contrasenia = binding.txtContrasenia.text.toString()

            if (validateForm()) {
                val intent = Intent(this, MenuActivity::class.java)
                intent.putExtra("nombreUsuario", usuario)

                sharedPref.savePref("userNameKey", usuario)
                sharedPref.savePref("userPasswordKey", contrasenia)
                sharedPref.savePref("userIsLoggedKey", true)

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