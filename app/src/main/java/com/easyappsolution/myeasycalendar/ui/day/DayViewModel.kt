package com.easyappsolution.myeasycalendar.ui.day

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyappsolution.myeasycalendar.repos.EventsDatabase
import com.easyappsolution.myeasycalendar.repos.EventsRepository
import com.easyappsolution.myeasycalendar.repos.models.DayEvent
import com.easyappsolution.myeasycalendar.repos.models.DayModel
import java.util.*

class DayViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:EventsRepository

    var dayData =  MutableLiveData<DayModel>()

    lateinit var eventsData : LiveData<List<DayEvent>>

    var isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    init {
        val wordsDao = EventsDatabase.getDatabase(application).events()
        repository = EventsRepository(wordsDao)
        checkCurrentDay()
    }

    //simulamos la llamada asincrona
    fun checkCurrentDay(){
        processBegin()
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        eventsData = repository.getEventsOnDay("$day/${month + 1}/$year")
        processFinished()
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun processBegin() {
        isLoading.value = false
    }
}