package com.berno.alarmapp.model

import com.berno.alarmapp.R

class AlaramItem(description : String, alarmDate : String) {
     var description: String = description
     var alarmDate: String = alarmDate
     var alarmResId: Int = R.id.clock_img
     var deleteResId: Int =R.id.delete_button

}