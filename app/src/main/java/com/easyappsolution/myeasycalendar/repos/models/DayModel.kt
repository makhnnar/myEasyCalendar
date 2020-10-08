package com.easyappsolution.myeasycalendar.repos.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "day_table")
class DayModel{

    @NonNull
    @ColumnInfo(name = "id")
    val id:String

    @NonNull
    @ColumnInfo(name = "numberInYear")
    val numberInYear:Int

    @NonNull
    @ColumnInfo(name = "numberOfYear")
    val numberOfYear:Int

    @NonNull
    @ColumnInfo(name = "numberInMonth")
    val numberInMonth:Int

    @NonNull
    @ColumnInfo(name = "numberOfMonth")
    val numberOfMonth:Int

    @NonNull
    @ColumnInfo(name = "name")
    val name:String

    val activitiesList: List<DayEvent>

    constructor(
        id:String,
        numberInYear:Int,
        numberOfYear:Int,
        numberInMonth:Int,
        numberOfMonth:Int,
        name:String,
        activitiesList: List<DayEvent>
    ){
        this.id = id
        this.numberInYear = numberInYear
        this.numberOfYear = numberOfYear
        this.numberInMonth = numberInMonth
        this.numberOfMonth = numberOfMonth
        this.name = name
        this.activitiesList = activitiesList
    }

}