package com.gsamdev.clase1.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("DB_CLASE1", Context.MODE_PRIVATE)
    }

    fun savePref(key: String, value: Any) {
        val editor = sharedPreferences.edit()
        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            else -> throw IllegalArgumentException("Este tipo de datos no puede ser guardado")
        }
        editor.apply()
    }

    fun getPref(key: String, defaultValue: Any): Any {
       return when(defaultValue){
            is String -> sharedPreferences.getString(key, defaultValue)
            is Int -> sharedPreferences.getInt(key, defaultValue)
            is Long-> sharedPreferences.getLong(key, defaultValue)
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue)
            is Float -> sharedPreferences.getFloat(key, defaultValue)
            else -> throw  IllegalArgumentException("No es posible obtener este tipo de dato")
        }!!
    }

}