package com.dorrrke.test_task.db

import Terminal
import Worktable
import Worktables
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.core.database.getStringOrNull
import com.dorrrke.test_task.jsonModel.TerminalDb

class dbManeger(context: Context) {
    val dbHelper = dbHelper(context)
    var db: SQLiteDatabase? = null


    fun openDb() {
        db = dbHelper.writableDatabase
    }

    fun clearTerminals() {
        db?.execSQL(DataBase.SQL_DELETE_TABLE_1)
        dbHelper.onCreate(db)
    }

    fun clearWorktable() {
        db?.execSQL(DataBase.SQL_DELETE_TABLE_2)
        dbHelper.onCreate(db)
    }

    fun insertIntoTerminals(terminal: Terminal) {
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

        db?.insert(DataBase.TABLE_NAME_1, null, values)
    }

    fun insertIntoWorktable(worktable: Worktable, terminal_id: Int) {
        val values = ContentValues().apply {
            put(DataBase.COLUMN_NAME_DEPARTMENT, worktable.department)
            put(DataBase.COLUMN_NAME_MONDAY, worktable.monday)
            put(DataBase.COLUMN_NAME_TUESDAY, worktable.tuesday)
            put(DataBase.COLUMN_NAME_WEDNESDAY, worktable.wednesday)
            put(DataBase.COLUMN_NAME_THURSDAY, worktable.thursday)
            put(DataBase.COLUMN_NAME_FRIDAY, worktable.friday)
            put(DataBase.COLUMN_NAME_SATURDAY, worktable.saturday)
            put(DataBase.COLUMN_NAME_SUNDAY, worktable.sunday)
            put(DataBase.COLUMN_NAME_TIMETABLE, worktable.timetable)
            put(DataBase.COLUMN_NAME_TERMINAL_ID, terminal_id)
        }

        db?.insert(DataBase.TABLE_NAME_2, null, values)
    }

    fun readDbData(): ArrayList<TerminalDb> {
        val data = ArrayList<TerminalDb>()
        val cursor: Cursor
        val cursorWork: Cursor
        val sqlTerminalQuery = DataBase.SELECT_TERMINALS_FROM
        cursor = db?.rawQuery(sqlTerminalQuery, null)!!
        var str: String = ""
        //while (cursor?.moveToNext()) {
        var i : Int = 0
        if ( cursor.moveToFirst() ) {
            do {
                var terminal = TerminalDb()
                var worktableList = ArrayList<Worktable>()
                if (data.isEmpty())
                {
                    terminal.name = cursor.getString(cursor.getColumnIndex("name"))
                    terminal.address = cursor.getString(cursor.getColumnIndex("address"))
                    terminal.latitude = cursor.getDouble(cursor.getColumnIndex("latitude"))
                    terminal.longitude = cursor.getDouble(cursor.getColumnIndex("longitude"))
                    terminal.maps = cursor.getString(cursor.getColumnIndex("maps_url"))
                    worktableList.add(Worktable(cursor.getString(cursor.getColumnIndex("department")),
                        cursor.getString(cursor.getColumnIndex("monday")),
                        cursor.getString(cursor.getColumnIndex("tuesday")),
                        cursor.getString(cursor.getColumnIndex("wednesday")),
                        cursor.getString(cursor.getColumnIndex("thursday")),
                        cursor.getString(cursor.getColumnIndex("friday")),
                        cursor.getString(cursor.getColumnIndex("saturday")),
                        cursor.getString(cursor.getColumnIndex("sunday")),
                        cursor.getString(cursor.getColumnIndex("timetable"))))
                    terminal.worktables = worktableList
                    data.add(i, terminal)
                    i++
                }
                else
                {
                    if (data[i-1].name == cursor.getString(cursor.getColumnIndex("name")))
                    {
                        data[i-1].worktables.add(Worktable(cursor.getString(cursor.getColumnIndex("department")),
                            cursor.getString(cursor.getColumnIndex("monday")),
                            cursor.getString(cursor.getColumnIndex("tuesday")),
                            cursor.getString(cursor.getColumnIndex("wednesday")),
                            cursor.getString(cursor.getColumnIndex("thursday")),
                            cursor.getString(cursor.getColumnIndex("friday")),
                            cursor.getString(cursor.getColumnIndex("saturday")),
                            cursor.getString(cursor.getColumnIndex("sunday")),
                            cursor.getString(cursor.getColumnIndex("timetable"))))
                    }
                    else
                    {
                        terminal.name = cursor.getString(cursor.getColumnIndex("name"))
                        terminal.address = cursor.getString(cursor.getColumnIndex("address"))
                        terminal.latitude = cursor.getDouble(cursor.getColumnIndex("latitude"))
                        terminal.longitude = cursor.getDouble(cursor.getColumnIndex("longitude"))
                        terminal.maps = cursor.getString(cursor.getColumnIndex("maps_url"))
                        worktableList.add(Worktable(cursor.getString(cursor.getColumnIndex("department")),
                            cursor.getString(cursor.getColumnIndex("monday")),
                            cursor.getString(cursor.getColumnIndex("tuesday")),
                            cursor.getString(cursor.getColumnIndex("wednesday")),
                            cursor.getString(cursor.getColumnIndex("thursday")),
                            cursor.getString(cursor.getColumnIndex("friday")),
                            cursor.getString(cursor.getColumnIndex("saturday")),
                            cursor.getString(cursor.getColumnIndex("sunday")),
                            cursor.getString(cursor.getColumnIndex("timetable"))))
                        terminal.worktables = worktableList
                        data.add(i, terminal)
                        i++
                    }
                }
            }while (cursor.moveToNext())
        }
        return data
    }
}