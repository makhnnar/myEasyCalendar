package com.easyappsolution.myeasycalendar.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.easyappsolution.myeasycalendar.R
import com.easyappsolution.myeasycalendar.databinding.ActivityEventBinding
import com.easyappsolution.myeasycalendar.ui.day.DayViewModel
import kotlinx.android.synthetic.main.activity_event.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    private lateinit var dayViewModel: DayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        dayViewModel = ViewModelProviders.of(this).get(DayViewModel::class.java)
    }

}
