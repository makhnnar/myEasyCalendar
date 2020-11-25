package com.easyappsolution.myeasycalendar.ui.day.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

class EventsAdapter(
    var onClickItemListener: OnClickItemListener,
    var dayEvents: List<DayEvent?>
) : RecyclerView.Adapter<EventsViewHolder>() {

    lateinit var context : Context

    //private var dayEvents: MutableList<DayEvent?> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        pos: Int
    ): EventsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        return EventsViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        Log.i("DATA", " size: getItemCount: ${dayEvents.size}")
        return dayEvents.size
        //return 4
    }

    override fun onBindViewHolder(
        viewHolder: EventsViewHolder,
        pos: Int
    ) {
        Log.i("DATA", " size: pos: $pos")
        configureViewHolder(viewHolder, pos)
    }

    private fun configureViewHolder(
        holder: EventsViewHolder,
        position: Int
    ) {
        if(dayEvents.isNotEmpty()){
            holder.setData(
                dayEvents[position]!!,
                position,
                onClickItemListener
            )
        }
    }

    fun updateAll(update: List<DayEvent>) {
        //dayEvents.clear()
        Log.i("DATA","size: updateAll: ${update.size}")
        //dayEvents = update.toMutableList()
        for (event:DayEvent in update){
            Log.i("DATA", " size: ${event.title}, ${event.horaInicio} - ${event.horaFinal}")
        }
        update.forEach {
            Log.i("DATA", " size: ${it.title}, ${it.horaInicio} - ${it.horaFinal}")
            //dayEvents.add(it)
        }
        Log.i("DATA", " size: getItemCount: ${dayEvents.size}")
        notifyDataSetChanged()
        notifyItemRangeInserted(0,dayEvents.size)
    }

    fun clear() {
        //dayEvents.clear()
        notifyDataSetChanged()
    }

    interface OnClickItemListener{

        fun onClickItem(
            dayEvent: DayEvent
        )

    }
}