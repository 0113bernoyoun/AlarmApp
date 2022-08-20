package com.berno.alarmapp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.berno.alarmapp.databinding.ActivityAddAlarmBinding

class NumberPickerDialog : DialogFragment() {
 private var _binding: ActivityAddAlarmBinding? = null
 private val binding get() = _binding

 override fun onCreateView(
  inflater: LayoutInflater,
  container: ViewGroup?,
  savedInstanceState: Bundle?
 ): View? {
  _binding = ActivityAddAlarmBinding.inflate(inflater, container, false)
  val view = binding?.root
  var hourPicker : NumberPicker? = binding?.hourPicker
  var minutePicker : NumberPicker? = binding?.minutePicker
  var amPmPicker : NumberPicker? = binding?.hourPicker
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