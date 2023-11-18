package com.gsamdev.clase1.data.sqlite.tables

import com.gsamdev.clase1.data.helpers.Constants.Companion.NAME_TABLE_HISTORY_GAMES

class HistoryGamesTbl {
    companion object {

        const val CREATE_GAME_HISTORY_TABLE = " CREATE TABLE $NAME_TABLE_HISTORY_GAMES " +
                " ( id INTEGER PRIMARY KEY AUTOINCREMENT , " +
                " nameGame TEXT NOT NULL , " +
                " idTeamWinner INTEGER NOT NULL , " +
                " idTeamLoser INTEGER NOT NULL , " +
                " pointsWinner TEXT NOT NULL , " +
                " pointsLoser TEXT NOT NULL ) "

        const val SELECT_HISTORY_TABLE =
            " SELECT * FROM $NAME_TABLE_HISTORY_GAMES ORDER BY pointsWinner DESC "
    }
}