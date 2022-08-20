package com.berno.alarmapp.model

class AlaramItem {
    private var _title:String? = null
    private val title get() = _title
    private var _alarmDate:String? = null

    constructor(title:String, alaramDate:String){
        _title=title
        _alarmDate = alaramDate
    }

}