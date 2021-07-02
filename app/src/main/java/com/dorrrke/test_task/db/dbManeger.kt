package com.dorrrke.test_task.db

import Terminal
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase

class dbManeger(context: Context) {
    val dbHelper = dbHelper(context)
    var db: SQLiteDatabase? = null


    fun openDb() {
        db = dbHelper.writableDatabase
    }

    fun clearTable ()
    {
        db?.execSQL(DataBase.SQL_DELETE_TABLE)
        dbHelper.onCreate(db)
    }
    fun insert( terminal: Terminal)
    {
        val values = ContentValues().apply {
            put(DataBase.COLUMN_NAME_NAME, terminal.name)
            put(DataBase.COLUMN_NAME_ADDRESS, terminal.address)
            put(DataBase.COLUMN_NAME_LATITUDE, terminal.latitude)
            put(DataBase.COLUMN_NAME_LONGITUDE, terminal.longitude)
            put(DataBase.COLUMN_NAME_RECEIVE_CARGO, terminal.receiveCargo)
            put(DataBase.COLUMN_NAME_GIVE_OUT_CARGO, terminal.giveoutCargo)
            put(DataBase.COLUMN_NAME_DEFAULT, terminal.default)
            put(DataBase.COLUMN_NAME_MAP_URL, terminal.maps.width.bigSize.height.bigSize.url)
        }

        db?.insert(DataBase.TABLE_NAME, null, values)
    }
}