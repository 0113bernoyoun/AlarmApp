package com.berno.alarmapp.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.widget.Toast

object DBUtil {

    val DB_LOGCAT_TAG = "DBUTIL"

    val TIME_COLUMN : String = "time"
    val DESCRIPTION_COLUMN : String = "description"
    val TABLE_NAME : String = "alarmTable"
    val DB_FILE_NAME : String = "alarm.db"
    val DB_INSERT_ERROR_CODE : Long = -1
    val TIME_SEPERATOR : String = "!@"

    lateinit var helper : DBHelper
    lateinit var db : SQLiteDatabase
    fun createDB(context : Context, dbfileName : String){
        helper = DBHelper(context, dbfileName, null, 1)
        db = helper.writableDatabase
        helper.onCreate(db)
    }

    fun insertData(context : Context, description : String, time : String){
        var values : ContentValues = ContentValues()
        values.put(TIME_COLUMN, time)
        values.put(DESCRIPTION_COLUMN, description)
        var result : Long = db.insert(TABLE_NAME, null, values)
        if(result == DB_INSERT_ERROR_CODE){
            Toast.makeText(context, "알람 추가 실패", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "알람 추가", Toast.LENGTH_SHORT).show();
        }
    }

    fun deleteData(context: Context, id : Int, time : String){

        var result = db.delete(TABLE_NAME, "ID=? and time=?", arrayOf(id.toString(), time))
        if(result == 0){
            Toast.makeText(context, "지울 대상이 없습니다.", Toast.LENGTH_SHORT).show();
            Log.d(DB_LOGCAT_TAG, "지울 대상이 없습니다.\nclause :: " + "ID=? and time=?" + "\nvalue :: " + id.toString() + ", " + time)
        }
    }

}