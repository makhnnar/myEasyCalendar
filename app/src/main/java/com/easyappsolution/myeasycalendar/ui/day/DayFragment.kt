package com.easyappsolution.myeasycalendar.ui.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyappsolution.myeasycalendar.R
import com.easyappsolution.myeasycalendar.ui.day.adapter.DayAdapter
import com.easyappsolution.myeasycalendar.ui.day.data.DayEvent
import kotlinx.android.synthetic.main.fragment_day_view.*

class DayFragment : Fragment(),DayAdapter.OnClickItemListener {

    private lateinit var dayViewModel: DayViewModel

    private val adapter = DayAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dayViewModel =
            ViewModelProviders.of(this).get(DayViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_day_view, container, false)
        initRecyclerView()
        dayViewModel.text.observe(this, Observer {
            adapter.updateAll(it.activitiesList)
        })
        return root
    }

    private fun initRecyclerView() {
        rvDayEvents.adapter = adapter
        rvDayEvents.layoutManager = LinearLayoutManager(context)
    }

    override fun onClickItem(dayEvent: DayEvent) {

    }

}