package com.easyappsolution.myeasycalendar.ui.day.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

class DayAdapter(var onClickItemListener: OnClickItemListener) : RecyclerView.Adapter<DayViewHolder>() {

    lateinit var context : Context

    private var dayEvents: MutableList<DayEvent?> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        pos: Int
    ): DayViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return DayViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return dayEvents.size
    }

    override fun onBindViewHolder(
        viewHolder: DayViewHolder,
        pos: Int
    ) {
        configureViewHolder(viewHolder, pos)
    }

    private fun configureViewHolder(holder: DayViewHolder, position: Int) {
        holder.setData(
            dayEvents[position]!!,
            position,
            onClickItemListener
        )
    }

    fun updateAll(update: List<DayEvent>) {
        dayEvents.clear()
        dayEvents.addAll(update)
        notifyDataSetChanged()
    }

    fun clear() {
        dayEvents.clear()
        notifyDataSetChanged()
    }

    interface OnClickItemListener{

        fun onClickItem(
            dayEvent: DayEvent
        )

    }
}