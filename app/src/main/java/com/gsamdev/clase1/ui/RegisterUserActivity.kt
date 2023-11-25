package com.gsamdev.clase1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.data.sqlite.queries.UserQuery
import com.gsamdev.clase1.databinding.ActivityRegisterUserBinding
import com.gsamdev.clase1.models.UserModel

class RegisterUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterUserBinding
    private lateinit var userQuery: UserQuery

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterUserBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)

        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnRegister.setOnClickListener {
            val name = binding.txtUser.text.toString()
            val identification = binding.txtIdentification.text.toString()
            val password = binding.txtPassword.text.toString()
            //Aqui le pasamos los datos de cada uno de nuestros datos recuperaos del formulario
            //Falta adecuar el formulario para poder insertarle toda la informacion a la tabla usuarios

            /*Aqui le pasamos la informacion en el orden que este la data class UserModel*/
            val user = UserModel()
            userQuery.insertUser(user)
        }
    }
}