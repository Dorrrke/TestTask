package com.dorrrke.test_task.db

import android.provider.BaseColumns

object DataBase : BaseColumns {
    const val TABLE_NAME = "terminals"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_ADDRESS = "address"
    const val COLUMN_NAME_LATITUDE = "latitude"
    const val COLUMN_NAME_LONGITUDE = "longitude"
    const val COLUMN_NAME_RECEIVE_CARGO = "receiveCargo"
    const val COLUMN_NAME_GIVE_OUT_CARGO = "giveoutCargo"
    const val COLUMN_NAME_DEFAULT = "priznak"
    //const val COLUMN_NAME_WORKTABLE = "worktable"
    const val COLUMN_NAME_MAP_URL = "maps_url"

    const val DB_VERSION = 1
    const val DB_NAME = "Test_task"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$COLUMN_NAME_NAME TEXT," +
            "$COLUMN_NAME_ADDRESS TEXT," +
            "$COLUMN_NAME_LATITUDE REAL," +
            "$COLUMN_NAME_LONGITUDE REAL," +
            "$COLUMN_NAME_RECEIVE_CARGO INTEGER," +
            "$COLUMN_NAME_GIVE_OUT_CARGO INTEGER," +
            "$COLUMN_NAME_DEFAULT INTEGER," +
            "$COLUMN_NAME_MAP_URL TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}