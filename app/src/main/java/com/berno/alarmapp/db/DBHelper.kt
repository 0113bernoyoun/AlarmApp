package com.berno.alarmapp.db

import android.content.Context
import android.database.DatabaseErrorHandler
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int,
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(p0: SQLiteDatabase?) {
         var sql :String = "CREATE TABLE if not exists alarmTable (ID integer primary key autoincrement, time text, description text)"
         p0?.execSQL(sql);
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql : String = "DROP TABLE if exists alarmTable";
        p0?.execSQL(sql)
        onCreate(p0)
    }


}