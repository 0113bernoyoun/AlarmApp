package com.berno.alarmapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berno.alarmapp.model.AlaramItem
import org.w3c.dom.Text

class AlaramListAdaptor(private val context: Context) : RecyclerView.Adapter<AlaramListAdaptor.ViewHolder>() {

    var items : List<AlaramItem> = listOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlaramListAdaptor.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.alarm_item, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var alarmImageView : ImageView = view.findViewById(R.id.clock_img)
        var deleteImageButton : ImageButton = view.findViewById(R.id.delete_button)
        var alarmTitle : TextView = view.findViewById(R.id.alarm_title)
        var alarmTime : TextView = view.findViewById(R.id.alarm_time)

        fun onBind(item : AlaramItem){
            alarmImageView.setImageResource(R.drawable.alarm_clock)
            deleteImageButton.setImageResource(R.drawable.delete)
            alarmTitle.text = item.description
            alarmTime.text = item.alarmDate
        }


    }
}