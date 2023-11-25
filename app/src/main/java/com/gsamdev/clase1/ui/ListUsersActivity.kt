package com.gsamdev.clase1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.gsamdev.clase1.data.sqlite.queries.UserQuery
import com.gsamdev.clase1.databinding.ActivityListUsersBinding

class ListUsersActivity : AppCompatActivity() {
    private lateinit var userQuery: UserQuery
    private lateinit var binding: ActivityListUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUsersBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {
        val listUsers = userQuery.listAllUsers()
        binding.txtListUsers.text = listUsers.toString()
    }
}