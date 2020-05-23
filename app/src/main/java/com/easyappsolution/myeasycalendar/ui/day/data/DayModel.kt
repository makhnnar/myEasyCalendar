package com.easyappsolution.myeasycalendar.ui.day.data

import androidx.annotation.IntRange

class DayModel{

    val id:String

    @get:IntRange(from = 1, to = 366)
    val numberOfYear:Int

    @get:IntRange(from = 1, to = 31)
    val numberOfMonth:Int

    val name:String

    val activitiesList: List<DayEvent>

    constructor(
        id:String,
        numberOfYear:Int,
        numberOfMonth:Int,
        name:String,
        activitiesList: List<DayEvent>
    ){
        this.id = id
        this.numberOfYear = numberOfYear
        this.numberOfMonth = numberOfMonth
        this.name = name
        this.activitiesList = activitiesList
    }

}