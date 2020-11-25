package com.easyappsolution.myeasycalendar.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.easyappsolution.myeasycalendar.R
import com.easyappsolution.myeasycalendar.databinding.ActivityEventBinding
import com.easyappsolution.myeasycalendar.ui.day.DayViewModel
import kotlinx.android.synthetic.main.activity_event.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * TODO:
 *  - obtener datos de los view y guardar en bd
 *  - leer datos de bd una vez guardados
 *  - la fecha de fin debe ser igual o mayor a la fecha de incio
 *  - agregar la posibilidad de colocar eventos recurrentes, siempre o por periodo
 *  - agregar alerta de que los campos estan mal introducidos
 *
 */
class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    private lateinit var dayViewModel: EventViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        dayViewModel = ViewModelProvider(this).get(EventViewModel::class.java)
    }

    fun saveValues(v:View){
        dayViewModel.saveEvent(
            binding.nameEvent.text.toString(),
            binding.descriptionEvent.text.toString(),
            binding.iniEven.getDate().toString(),
            binding.endEven.getDate().toString()
        )
        this.finish()
    }

}
