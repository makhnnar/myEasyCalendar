package com.easyappsolution.myeasycalendar.ui.day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private lateinit var adapter : DayAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_day_view,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dayViewModel = ViewModelProviders.of(this).get(DayViewModel::class.java)
        adapter = DayAdapter(this)
        initRecyclerView()
        observeViewModel()
        dayViewModel.checkCurrentDay()
    }

    private fun initRecyclerView() {
        rvDayEvents.apply{
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun observeViewModel() {

        dayViewModel.dayData.observe(this, Observer {
            adapter.updateAll(it.activitiesList)
        })

        dayViewModel.isLoading.observe(this, Observer<Boolean> {
            rlBase.visibility = if(it) View.VISIBLE else View.GONE
        })
    }

    override fun onClickItem(dayEvent: DayEvent) {

    }

}