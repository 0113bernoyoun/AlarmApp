package com.berno.alarmapp.model

import com.berno.alarmapp.R

class AlaramItem(id : Int, description : String, alarmDate : String) {
     var description: String = description
     var alarmDate: String = alarmDate
     var id : Int = id
     var alarmResId: Int = R.id.clock_img
     var deleteResId: Int =R.id.delete_button

}