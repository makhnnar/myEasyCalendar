package com.easyappsolution.myeasycalendar.ui.month.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.easyappsolution.myeasycalendar.R
import kotlinx.android.synthetic.main.item_view_day.view.*

class DayView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    init {
        LayoutInflater.from(context)
            .inflate(
                R.layout.item_view_day,
                this,
                true
            )
        attrs.let {
            var a = context.obtainStyledAttributes(
                it,
                R.styleable.DayView
            )
            a.recycle()
        }
    }

    fun setDayData(
        dayNumber:String?,
        dayMainEventName:String?
    ){
        tvDayNumber?.text = dayNumber?:""
        tvDayMainEvent?.text = dayMainEventName?:""
    }
}