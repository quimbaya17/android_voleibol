package com.gsamdev.clase1.data.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.gsamdev.clase1.data.helpers.Constants.Companion.NAME_DATA_BASE
import com.gsamdev.clase1.data.helpers.Constants.Companion.VERSION_DATABASE
import com.gsamdev.clase1.data.sqlite.tables.HistoryGamesTbl.Companion.CREATE_GAME_HISTORY_TABLE
import com.gsamdev.clase1.data.sqlite.tables.TeamsGameTbl.Companion.CREATE_TEAM_TABLE
import com.gsamdev.clase1.data.sqlite.tables.UsersTbl.Companion.CREATE_USERS_TABLE

class DbHelper(context: Context) :
    SQLiteOpenHelper(context, NAME_DATA_BASE, null, VERSION_DATABASE) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_GAME_HISTORY_TABLE)
        db?.execSQL(CREATE_USERS_TABLE)
        db?.execSQL(CREATE_TEAM_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}