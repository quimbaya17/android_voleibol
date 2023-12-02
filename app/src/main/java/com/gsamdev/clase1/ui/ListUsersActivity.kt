package com.gsamdev.clase1.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gsamdev.clase1.data.sqlite.queries.UserQuery
import com.gsamdev.clase1.databinding.ActivityListUsersBinding
import com.gsamdev.clase1.ui.adapter.UserAdapter

class ListUsersActivity : AppCompatActivity() {

    private lateinit var userQuery: UserQuery
    private lateinit var binding: ActivityListUsersBinding

    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUsersBinding.inflate(LayoutInflater.from(this))
        userQuery = UserQuery(this)
        setContentView(binding.root)

        initUI()

    }

    private fun initUI() {

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val listUsers = userQuery.listAllUsers()
        userAdapter = UserAdapter(listUsers, this)
        recyclerView = binding.rvUsers
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = userAdapter
    }
}