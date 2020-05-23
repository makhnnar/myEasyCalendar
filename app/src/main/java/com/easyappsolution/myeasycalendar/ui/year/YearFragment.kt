package com.easyappsolution.myeasycalendar.ui.year

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.easyappsolution.myeasycalendar.R

class YearFragment : Fragment()  {

    private lateinit var yearViewModel: YearViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        yearViewModel =
            ViewModelProviders.of(this).get(YearViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_year_view, container, false)
        val textView: TextView = root.findViewById(R.id.text_year)
        yearViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

}