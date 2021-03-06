package com.easyappsolution.myeasycalendar.ui.week.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.easyappsolution.myeasycalendar.R
import com.easyappsolution.myeasycalendar.repos.models.DayModel

class WeekViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    inflater.inflate(
        R.layout.activity_view_holder,
        parent,
        false
    )
) {

    private var activitieContainer: ConstraintLayout? = null

    var context: Context

    init {
        activitieContainer = itemView.findViewById(R.id.activityContainer)
        context = parent.context
    }

    fun setData(
        data: DayModel,
        post: Int,
        onClickItemListener: WeekAdapter.OnClickItemListener
    ) {
        activitieContainer?.setOnClickListener(View.OnClickListener {
            onClickItemListener.onClickItem(
                data
            )
        })
    }
}