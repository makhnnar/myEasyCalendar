package com.easyappsolution.myeasycalendar.ui.components

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.DatePicker
import androidx.constraintlayout.widget.ConstraintLayout
import com.easyappsolution.myeasycalendar.R
import kotlinx.android.synthetic.main.date_picker_field.view.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Date picker with edit text.
 */
class DatePickerField : ConstraintLayout, OnDateSetListener,
    OnClickListener {

    private var selectedDay : Long? = null

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        LayoutInflater.from(context)
            .inflate(
                R.layout.date_picker_field,
                this,
                true
            )
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.DatePickerField,
            defStyle,
            0
        )
        a.recycle()
        etDate.isFocusable = false
        etDate.setOnClickListener(this)
    }

    override fun onDateSet(
        view: DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        val calendar = Calendar.getInstance()

        calendar.set(
            year,
            month,
            dayOfMonth
        )

        val date = calendar.time

        selectedDay = date.time

        println("Date : $selectedDay")

        etDate.setText("$dayOfMonth/${month + 1}/$year")
    }

    override fun onClick(v: View?) {
        if(etDate == v){
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val dialog = DatePickerDialog(
                context,
                android.R.style.Theme_Material_Dialog,
                this,
                year,
                month,
                day
            )
            dialog.window!!.setBackgroundDrawable(
                ColorDrawable(
                    Color.LTGRAY
                )
            )
            dialog.show()
        }
    }

    fun getDateAsString() = etDate.text

    fun getDateAsLong():Long{
        return selectedDay?:0L
    }

}
