package com.berno.alarmapp.view

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.berno.alarmapp.R
import com.berno.alarmapp.databinding.ActivityAddAlarmBinding
import com.berno.alarmapp.db.DBUtil
import com.google.android.material.textfield.TextInputEditText

class NumberPickerDialog(var activity: Activity, recyclerView: RecyclerView) : DialogFragment() {
 private var _binding: ActivityAddAlarmBinding? = null
 private val binding get() = _binding
 private var recyclerView = recyclerView
 private val AM_VALUE : Int = 0
 private val PM_VALUE : Int = 1
 private val AM_STRING : String = "AM"
 private val PM_STRING : String = "PM"
 var dataAdded : Boolean = false
 override fun onCreateView(
  inflater: LayoutInflater,
  container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  _binding = ActivityAddAlarmBinding.inflate(inflater, container, false)
  val view = binding?.root
  var hourPicker : NumberPicker? = binding?.hourPicker
  var minutePicker : NumberPicker? = binding?.minutePicker
  var amPmPicker : NumberPicker? = binding?.amPmPicker
  var addBtn : Button? = binding?.confirmButton
  var descriptionText : EditText? = binding?.description
  addBtn?.setOnClickListener(object : View.OnClickListener{
   override fun onClick(p0: View?) {
    lateinit var amPm : String
    if(amPmPicker?.value.toString().equals(AM_VALUE.toString())) amPm = AM_STRING else amPm = PM_STRING
    var hour = hourPicker?.value.toString()
    var minute = minutePicker?.value.toString()
    var time = "$amPm/$hour:$minute"
    if(DBUtil.insertData(activity, descriptionText?.text.toString(), time)){
     dataAdded = true
     recyclerView.adapter?.notifyDataSetChanged()
    }
    dismiss()
   }
  })
  hourPicker?.minValue = 0
  hourPicker?.maxValue = 12
  minutePicker?.maxValue = 59
  minutePicker?.minValue = 0
  amPmPicker?.minValue = 0
  amPmPicker?.maxValue = 1
  var amPmArr = arrayOf<String>("AM", "PM")

  amPmPicker?.displayedValues = amPmArr
  return view
 }

 override fun onDestroyView() {
  super.onDestroyView()
  _binding = null
 }
}