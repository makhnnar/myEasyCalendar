package com.easyappsolution.myeasycalendar.repos.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "week_table")
data class WeekModel(
    @NonNull
    @ColumnInfo(name = "id")
    var id:String,
    @NonNull
    @ColumnInfo(name = "numberOfYear")
    var numberOfYear:Int,
    @NonNull
    @ColumnInfo(name = "numberOfMonth")
    var numberOfMonth:Int,
    var daysList: List<DayModel>
)