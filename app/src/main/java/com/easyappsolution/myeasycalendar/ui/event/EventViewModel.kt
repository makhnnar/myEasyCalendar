package com.easyappsolution.myeasycalendar.ui.event

import android.app.Application
import android.os.CountDownTimer
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.easyappsolution.myeasycalendar.repos.EventsDatabase
import com.easyappsolution.myeasycalendar.repos.EventsRepository
import com.easyappsolution.myeasycalendar.repos.models.DayEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class EventViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EventsRepository

    lateinit var eventData : LiveData<DayEvent>

    var isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    init {
        val wordsDao = EventsDatabase.getDatabase(application).events()
        repository = EventsRepository(wordsDao)
    }

    //guardamos el evento
    fun saveEvent(
        title:String,
        description:String,
        hIni: Date,
        hFin: Date,
        date:String
    ) = viewModelScope.launch(Dispatchers.IO) {
        //processBegin()
        var event = DayEvent(
            date,
            title,
            description,
            hIni.toString(),
            hFin.toString()
        )
        repository.insert(
            event
        )
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun processBegin() {
        isLoading.value = false
    }
}