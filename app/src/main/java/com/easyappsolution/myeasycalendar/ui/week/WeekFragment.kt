package com.easyappsolution.myeasycalendar.ui.week

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
import com.easyappsolution.myeasycalendar.ui.day.data.DayModel
import com.easyappsolution.myeasycalendar.ui.week.adapter.WeekAdapter
import kotlinx.android.synthetic.main.fragment_day_view.*

class WeekFragment : Fragment(),WeekAdapter.OnClickItemListener {

    private lateinit var weekViewModel: WeekViewModel

    private lateinit var adapter : WeekAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_week_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weekViewModel = ViewModelProviders.of(this).get(WeekViewModel::class.java)
        adapter = WeekAdapter(this)
        initRecyclerView()
        observeViewModel()
        weekViewModel.checkCurrentDay()
    }

    private fun initRecyclerView() {
        rvDayEvents.apply{
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun observeViewModel() {

        weekViewModel.weekData.observe(this, Observer {
            adapter.updateAll(it.daysList)
        })

        weekViewModel.isLoading.observe(this, Observer<Boolean> {
            rlBase.visibility = if(it) View.VISIBLE else View.GONE
        })
    }

    override fun onClickItem(dayEvent: DayModel) {

    }
}