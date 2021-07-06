package com.dorrrke.test_task.db

import android.provider.BaseColumns

object DataBase : BaseColumns {

    const val DB_VERSION = 1
    const val DB_NAME = "Test_task"

    const val TABLE_NAME_1 = "terminals"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_ADDRESS = "address"
    const val COLUMN_NAME_LATITUDE = "latitude"
    const val COLUMN_NAME_LONGITUDE = "longitude"
    const val COLUMN_NAME_RECEIVE_CARGO = "receiveCargo"
    const val COLUMN_NAME_GIVE_OUT_CARGO = "giveoutCargo"
    const val COLUMN_NAME_DEFAULT = "priznak"
    const val COLUMN_NAME_MAP_URL = "maps_url"

    const val TABLE_NAME_2 = "worktable"
    const val COLUMN_NAME_DEPARTMENT = "department"
    const val COLUMN_NAME_MONDAY = "monday"
    const val COLUMN_NAME_TUESDAY = "tuesday"
    const val COLUMN_NAME_WEDNESDAY = "wednesday"
    const val COLUMN_NAME_THURSDAY = "thursday"
    const val COLUMN_NAME_FRIDAY = "friday"
    const val COLUMN_NAME_SATURDAY = "saturday"
    const val COLUMN_NAME_SUNDAY = "sunday"
    const val COLUMN_NAME_TIMETABLE = "timetable"
    const val COLUMN_NAME_TERMINAL_ID = "terminal_id"

    const val CREATE_TABLE_1 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME_1 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_NAME TEXT," +
            "$COLUMN_NAME_ADDRESS TEXT," +
            "$COLUMN_NAME_LATITUDE REAL," +
            "$COLUMN_NAME_LONGITUDE REAL," +
            "$COLUMN_NAME_RECEIVE_CARGO INTEGER," +
            "$COLUMN_NAME_GIVE_OUT_CARGO INTEGER," +
            "$COLUMN_NAME_DEFAULT INTEGER," +
            "$COLUMN_NAME_MAP_URL TEXT)"

    const val CREATE_TABLE_2 = "CREATE TABLE IF NOT EXISTS $TABLE_NAME_2 (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_DEPARTMENT TEXT," +
            "$COLUMN_NAME_MONDAY TEXT," +
            "$COLUMN_NAME_TUESDAY TEXT," +
            "$COLUMN_NAME_WEDNESDAY TEXT," +
            "$COLUMN_NAME_THURSDAY TEXT," +
            "$COLUMN_NAME_FRIDAY TEXT," +
            "$COLUMN_NAME_SATURDAY TEXT," +
            "$COLUMN_NAME_SUNDAY TEXT," +
            "$COLUMN_NAME_TIMETABLE TEXT," +
            "$COLUMN_NAME_TERMINAL_ID INTEGER NOT NULL," +
            "FOREIGN KEY (terminal_id) REFERENCES terminals(_id))"

    const val SELECT_TERMINALS_FROM = "SELECT * FROM $TABLE_NAME_1 LEFT JOIN $TABLE_NAME_2 ON $TABLE_NAME_1._ID = $TABLE_NAME_2.terminal_id " +
            "WHERE $TABLE_NAME_1.$COLUMN_NAME_RECEIVE_CARGO=1"

    const val SQL_DELETE_TABLE_1 = "DROP TABLE IF EXISTS $TABLE_NAME_1"
    const val SQL_DELETE_TABLE_2 = "DROP TABLE IF EXISTS $TABLE_NAME_2"

}