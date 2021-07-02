package com.dorrrke.test_task.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dbHelper(context: Context) : SQLiteOpenHelper(context, DataBase.DB_NAME, null, DataBase.DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DataBase.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DataBase.SQL_DELETE_TABLE)
        onCreate(db)
    }

}