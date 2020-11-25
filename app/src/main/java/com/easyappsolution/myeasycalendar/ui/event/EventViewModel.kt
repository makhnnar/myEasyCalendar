package com.easyappsolution.myeasycalendar.ui.event

import android.app.Application
import android.os.CountDownTimer
import android.util.Log
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

    val TAG = EventViewModel::class.java.simpleName

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
        hIni: String,
        hFin: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        //processBegin()
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        var event = DayEvent(
            "$day/${month + 1}/$year",
            title,
            description,
            hIni,
            hFin
        )
        val result = repository.insert(
            event
        )
        if (result > -1) {
            Log.i(TAG, "saveEvent: Elemento agregado")
        }else{
            Log.i(TAG, "saveEvent: Elemento no agregado. Error")
        }
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun processBegin() {
        isLoading.value = false
    }
}