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

class DayViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:EventsRepository

    var dayData =  MutableLiveData<DayModel>()

    var eventsData : LiveData<List<DayEvent>>

    var isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    init {
        val wordsDao = EventsDatabase.getDatabase(application).events()
        repository = EventsRepository(wordsDao)
        eventsData = repository.getEventsOnDay("22/03/2020")
    }

    //simulamos la llamada asincrona
    fun checkCurrentDay(){
        processBegin()
        object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                dayData.postValue(
                    DayModel(
                        "1",
                        33,
                        33,
                        12,
                        12,
                        "martes",
                        mutableListOf()
                    )
                )
                processFinished()
            }
        }.start()
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun processBegin() {
        isLoading.value = false
    }
}