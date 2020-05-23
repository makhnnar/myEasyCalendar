package com.easyappsolution.myeasycalendar.ui.week.data

import com.easyappsolution.myeasycalendar.ui.day.data.DayModel

data class WeekModel(
    var id:String,
    var numberOfYear:Int,
    var numberOfMonth:Int,
    var daysList: List<DayModel>
)