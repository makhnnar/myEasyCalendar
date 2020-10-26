package com.easyappsolution.myeasycalendar.ui.month

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.easyappsolution.myeasycalendar.databinding.FragmentMonthViewBinding

class MonthFragment : Fragment() {

    private lateinit var binding : FragmentMonthViewBinding

    private lateinit var monthViewModel: MonthViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        monthViewModel =
            ViewModelProvider(this).get(MonthViewModel::class.java)

        binding = FragmentMonthViewBinding.inflate(
            inflater,
            container,
            false
        )
        val root = binding.root

        monthViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotifications.text = it
        })
        return root
    }
}