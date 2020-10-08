package com.easyappsolution.myeasycalendar.repos.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "eventondays_table")
data class EventOnDays(
    @NonNull
    @ColumnInfo(name = "id")
    var id:String,
    @NonNull
    @ColumnInfo(name = "id_event")
    var idEvent:String,
    @NonNull
    @ColumnInfo(name = "id_day")
    var idDay:String
)