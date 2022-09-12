package com.berno.alarmapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.berno.alarmapp.AlaramListAdaptor
import com.berno.alarmapp.R
import com.berno.alarmapp.db.DBUtil

class MainActivity : AppCompatActivity() {
        lateinit var button : Button
        lateinit var deleteAllButton : Button
        var adaptor = AlaramListAdaptor(this)
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
            DBUtil.createDB(this, DBUtil.DB_FILE_NAME)

            button = findViewById<Button>(R.id.add_alarm_btn)
            deleteAllButton = findViewById<Button>(R.id.delete_all_btn)
            button.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    var recyclerView : RecyclerView = findViewById(R.id.alarm_list_view)
                    recyclerView.adapter = adaptor
                    val dialog = NumberPickerDialog(this@MainActivity, recyclerView)
                    dialog.show(supportFragmentManager, "customdialog")
                }
            })

            deleteAllButton.setOnClickListener(object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    DBUtil.deleteAllData()
                    init()
                }
            })

            init()

    }

    private fun init(){
        var recyclerView : RecyclerView = findViewById(R.id.alarm_list_view)
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adaptor
        adaptor.items = DBUtil.readAllData()
        adaptor.notifyDataSetChanged()

    }

    override fun onRestart() {
        super.onRestart()
        var recyclerView : RecyclerView = findViewById(R.id.alarm_list_view)
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.refreshDrawableState()
    }
}