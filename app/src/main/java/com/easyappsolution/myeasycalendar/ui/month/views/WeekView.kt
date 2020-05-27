package com.easyappsolution.myeasycalendar.ui.month.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.easyappsolution.myeasycalendar.R

class WeekView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle){

    init {
        LayoutInflater.from(context)
            .inflate(
                R.layout.item_view_week,
                this,
                true
            )
        attrs.let {
            var a = context.obtainStyledAttributes(
                it,
                R.styleable.WeekView
            )
            a.recycle()
        }
    }
}