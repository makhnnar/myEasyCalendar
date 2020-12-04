package com.easyappsolution.myeasycalendar.repos.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "dayevent_table")
data class DayEvent(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id:Long,
    @NonNull
    @ColumnInfo(name = "date")
    var date:String,
    @NonNull
    @ColumnInfo(name = "title")
    var title:String,
    @NonNull
    @ColumnInfo(name = "descripcion")
    var descripcion:String?,
    @NonNull
    @ColumnInfo(name = "horaInicio")
    var horaInicio: Long,//cambiar este tipo de datos por un primitivo
    @NonNull
    @ColumnInfo(name = "horaFinal")
    var horaFinal: Long,
    @NonNull
    @ColumnInfo(name = "isDestacada")
    var isDestacada:Boolean = false
){
    constructor(
        date:String,
        title: String,
        descripcion: String,
        horaInicio: Long,
        horaFinal: Long
    ) : this(0, date,title, descripcion,horaInicio,horaFinal)
}