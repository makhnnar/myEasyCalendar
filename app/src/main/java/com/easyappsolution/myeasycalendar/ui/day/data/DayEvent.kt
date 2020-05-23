package com.easyappsolution.myeasycalendar.ui.day.data

import java.util.*

data class DayEvent(
    var id:String,
    var title:String,
    var descripcion:String?,
    var horaInicio: Date,
    var horaFinal: Date,
    var isDestacada:Boolean
)