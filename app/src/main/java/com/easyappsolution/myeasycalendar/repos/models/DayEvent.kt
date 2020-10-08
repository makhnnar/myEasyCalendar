package com.easyappsolution.myeasycalendar.repos.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "dayevent_table")
data class DayEvent(
    @NonNull
    @ColumnInfo(name = "id")
    var id:String,
    @NonNull
    @ColumnInfo(name = "title")
    var title:String,
    @NonNull
    @ColumnInfo(name = "descripcion")
    var descripcion:String?,
    @NonNull
    @ColumnInfo(name = "horaInicio")
    var horaInicio: Date,
    @NonNull
    @ColumnInfo(name = "horaFinal")
    var horaFinal: Date,
    @NonNull
    @ColumnInfo(name = "isDestacada")
    var isDestacada:Boolean
)