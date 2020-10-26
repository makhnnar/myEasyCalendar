package com.easyappsolution.myeasycalendar.ui.day

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyappsolution.myeasycalendar.databinding.FragmentDayViewBinding
import com.easyappsolution.myeasycalendar.ui.day.adapter.DayAdapter
import com.easyappsolution.myeasycalendar.repos.models.DayEvent
import com.easyappsolution.myeasycalendar.ui.event.EventActivity

class DayFragment : Fragment(),
    DayAdapter.OnClickItemListener,
    View.OnClickListener{

    private lateinit var binding : FragmentDayViewBinding

    private lateinit var dayViewModel: DayViewModel

    private lateinit var adapter : DayAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayViewBinding.inflate(
            inflater,
            container,
            false
        )
        val root = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dayViewModel = ViewModelProvider(this).get(DayViewModel::class.java)
        adapter = DayAdapter(this)
        initRecyclerView()
        observeViewModel()
        dayViewModel.checkCurrentDay()
        binding.addEvent.setOnClickListener(this)
    }

    private fun initRecyclerView() {
        binding.rvDayEvents.apply{
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun observeViewModel() {

        dayViewModel.dayData.observe(viewLifecycleOwner, Observer {
            adapter.updateAll(it.activitiesList)
        })

        dayViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            binding.rlBase.visibility = if(it) View.VISIBLE else View.GONE
        })
    }

    override fun onClickItem(dayEvent: DayEvent) {

    }

    override fun onClick(v: View?) {
        when(v){
            binding.addEvent ->{
                startActivity(
                    Intent(
                        activity,
                        EventActivity::class.java
                    )
                )
            }
        }
    }

}