package com.easyappsolution.myeasycalendar.ui.month.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.easyappsolution.myeasycalendar.R

class MonthView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    /**
     * TODO:
     *  - Teminar esta vista
     *  - utilizar etiquetas merge para eliminar profundida de views
     *  - usar un rv para las semanas, siendo el numero maximo posible de semanas 6
     *  - agregar listener a los dias dentro del view de semana
     *  - obtener el calendario a traves de las apis de calendario de android
     * */

    init {
        LayoutInflater.from(context)
            .inflate(
                R.layout.item_view_month,
                this,
                true
            )
        attrs.let {
            var a = context.obtainStyledAttributes(
                it,
                R.styleable.MonthView
            )
            a.recycle()
        }
    }
}