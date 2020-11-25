package com.easyappsolution.myeasycalendar.ui.day.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.easyappsolution.myeasycalendar.R
import com.easyappsolution.myeasycalendar.databinding.ViewHolderEventBinding
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

class EventsViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.view_holder_event,
        parent,
        false
    )
) {

    var context: Context

    private var binding: ViewHolderEventBinding? = null

    init {
        binding = ViewHolderEventBinding.bind(itemView)
        context = parent.context
        Log.i("DATA", " size: created")
    }

    fun setData(
        data: DayEvent,
        post: Int,
        onClickItemListener: EventsAdapter.OnClickItemListener
    ) {
        Log.i("DATA", " size: ${data.title}, ${data.horaInicio} - ${data.horaFinal}")
        binding?.tvNameEvent?.text = data.title
        binding?.tvTimeEvent?.text = "${data.horaInicio} - ${data.horaFinal}"
    }
}