package com.gsamdev.clase1.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.data.prefs.SharedPreferencesManager
import com.gsamdev.clase1.data.sqlite.queries.AuthQuery
import com.gsamdev.clase1.data.sqlite.queries.UserQuery
import com.gsamdev.clase1.databinding.ActivityMainBinding
import com.gsamdev.clase1.models.UserModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPref: SharedPreferencesManager
    private lateinit var queryAuth: AuthQuery
    private lateinit var queryUser: UserQuery

    private var usuario = ""
    private var contrasenia = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        sharedPref = SharedPreferencesManager(this)
        queryAuth = AuthQuery(this)
        queryUser = UserQuery(this)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnIngresar.setOnClickListener {

            usuario = binding.txtUsuario.text.toString()
            contrasenia = binding.txtContrasenia.text.toString()

            if (validateForm()) {
                val user = UserModel(
                    name = "Guillermo",
                    identification = "121",
                    phone = "1222",
                    email = "gsamdev@gmail.com",
                    userName = "gsamdev",
                    role = "adminnn",
                    password = "123"
                )

                loginAuth()
            }

        }
    }

    private fun loginAuth() {
        val response = queryAuth.login(usuario, contrasenia)
        if (response != null) {
            sharedPref.savePref("userIsLoggedKey", true)
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validateForm(): Boolean {
        return if (binding.txtUsuario.text.toString().isEmpty()) {
            Toast.makeText(this, "Por favor dijite su usuario", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

}