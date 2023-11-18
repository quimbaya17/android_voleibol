package com.gsamdev.clase1.data.sqlite.tables

import com.gsamdev.clase1.data.helpers.Constants.Companion.NAME_TABLE_USERS

class UsersTbl {
    companion object {

        const val CREATE_USERS_TABLE = " CREATE TABLE $NAME_TABLE_USERS " +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " name TEXT NOT NULL , " +
                " identification TEXT NOT NULL , " +
                " phone TEXT NOT NULL , " +
                " email TEXT NOT NULL , " +
                " userName TEXT NOT NULL , " +
                " role TEXT NOT NULL , " +
                " password TEXT NOT NULL ) "

        const val SELECT_USERS_TABLE =
            " SELECT id, name, identification, phone, email, userName, role FROM $NAME_TABLE_USERS "

    }
}