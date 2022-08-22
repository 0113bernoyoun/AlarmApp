package com.berno.alarmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.berno.alarmapp.R
import com.berno.alarmapp.db.DBUtil

class MainActivity : AppCompatActivity() {
        lateinit var button : Button
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
            DBUtil.createDB(this, DBUtil.DB_FILE_NAME)
            button = findViewById<Button>(R.id.add_alarm_btn)
            button.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val dialog = NumberPickerDialog(this@MainActivity)
                    dialog.show(supportFragmentManager, "customdialog")
                }
            })

    }
}