package com.berno.alarmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
        lateinit var button : Button
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
            button = findViewById<Button>(R.id.button)
            button.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val dialog = NumberPickerDialog()
                    dialog.show(supportFragmentManager, "customdialog")

                }
            })

    }
}