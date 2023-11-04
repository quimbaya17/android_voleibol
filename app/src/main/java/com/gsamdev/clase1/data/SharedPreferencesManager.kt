package com.gsamdev.clase1.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("DB_CLASE1", Context.MODE_PRIVATE)
    }

    fun saveUserName(username: String) {
        val editor = sharedPreferences.edit()
        editor.putString("keyUserName", username)
        editor.apply()
    }

    //Create function for save a Boolean

    //Create a function for get as Boolean

    fun getUserName(): String =
        sharedPreferences.getString("keyUserName", "Empty").toString()


}