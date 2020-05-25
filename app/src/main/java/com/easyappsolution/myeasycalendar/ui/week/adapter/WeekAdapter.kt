package com.easyappsolution.myeasycalendar.ui.week.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyappsolution.myeasycalendar.ui.day.data.DayModel

class WeekAdapter (var onClickItemListener: OnClickItemListener) : RecyclerView.Adapter<WeekViewHolder>() {

    lateinit var context : Context

    private var daysList: MutableList<DayModel?> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        pos: Int
    ): WeekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return WeekViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return daysList.size
    }

    override fun onBindViewHolder(
        viewHolder: WeekViewHolder,
        pos: Int
    ) {
        configureViewHolder(viewHolder, pos)
    }

    private fun configureViewHolder(holder: WeekViewHolder, position: Int) {
        holder.setData(
            daysList[position]!!,
            position,
            onClickItemListener
        )
    }

    fun updateAll(update: List<DayModel>) {
        daysList.clear()
        daysList.addAll(update)
        notifyDataSetChanged()
    }

    fun clear() {
        daysList.clear()
        notifyDataSetChanged()
    }

    interface OnClickItemListener{

        fun onClickItem(
            dayEvent: DayModel
        )

    }
}