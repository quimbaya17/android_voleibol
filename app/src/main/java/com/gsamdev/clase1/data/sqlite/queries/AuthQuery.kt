package com.gsamdev.clase1.data.sqlite.queries

import android.annotation.SuppressLint
import android.content.Context
import com.gsamdev.clase1.data.helpers.Constants.Companion.NAME_TABLE_USERS
import com.gsamdev.clase1.data.sqlite.DbManager
import com.gsamdev.clase1.models.UserModel

class AuthQuery(private val context: Context) {

    @SuppressLint("Recycle")
    fun login(usernameOrEmail: String, password: String): UserModel? {
        val dbManager = DbManager(context)
        dbManager.openDbRead()
        val db = dbManager.dbInstance()
        val selection = "(userName = ? OR email = ?) AND password = ?"
        val selectionArgs = arrayOf(usernameOrEmail, usernameOrEmail, password)

        val response = db.query(
            NAME_TABLE_USERS, null, selection, selectionArgs,
            null, null, null
        )
        val user = UserModel()

        if (response.moveToFirst()) {
            user.id = response.getString(response.getColumnIndexOrThrow("id")).toInt()
            user.name = response.getString(response.getColumnIndexOrThrow("name"))
            user.identification = response.getString(response.getColumnIndexOrThrow("identification"))
            user.phone = response.getString(response.getColumnIndexOrThrow("phone"))
            user.email = response.getString(response.getColumnIndexOrThrow("email"))
            user.userName = response.getString(response.getColumnIndexOrThrow("userName"))
            user.role = response.getString(response.getColumnIndexOrThrow("role"))

            response.close()
            //dbManager.dbClose()
            return user
        } else {
            response.close()
            //dbManager.dbClose()
            return null
        }
    }


}