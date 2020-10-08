package com.easyappsolution.myeasycalendar.ui.year

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.easyappsolution.myeasycalendar.databinding.FragmentDayViewBinding

class YearFragment : Fragment()  {

    private lateinit var binding : FragmentDayViewBinding

    private lateinit var yearViewModel: YearViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        yearViewModel =
            ViewModelProviders.of(this).get(YearViewModel::class.java)

        binding = FragmentDayViewBinding.inflate(
            inflater,
            container,
            false
        )
        val root = binding.root

        yearViewModel.text.observe(this, Observer {
            //binding.textView.text = it
        })
        return root
    }

}