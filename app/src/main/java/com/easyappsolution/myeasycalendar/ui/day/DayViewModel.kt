package com.easyappsolution.myeasycalendar.ui.day

import android.app.Application
import android.os.CountDownTimer
import android.util.Log
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

    var dayString =  MutableLiveData<String>()

    var dayDifference = 0L

    lateinit var eventsData : LiveData<List<DayEvent>>

    var isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    init {
        val wordsDao = EventsDatabase.getDatabase(application).events()
        repository = EventsRepository(wordsDao)
        checkCurrentDay()
    }

    fun checkCurrentDay(){
        calculateDay(0)
    }

    private fun calculateDay(dayDiff:Long){
        processBegin()

        dayDifference += dayDiff

        val currentDate = Calendar.getInstance()

        val newDate = Calendar.getInstance()

        newDate.timeInMillis = currentDate.timeInMillis + dayDifference

        val year = newDate.get(Calendar.YEAR)
        val month = newDate.get(Calendar.MONTH)
        val day = newDate.get(Calendar.DAY_OF_MONTH)

        dayString.value = "$day/${month + 1}/$year"

        Log.i("mills","${newDate.timeInMillis}")

        eventsData = repository.getEventsOnDay(newDate.timeInMillis)
        processFinished()
    }

    fun getPrevDay(){
        calculateDay(-86400000L)
    }

    fun getNextDay(){
        calculateDay(86400000L)
    }

    private fun processFinished() {
        isLoading.value = true
    }

    private fun processBegin() {
        isLoading.value = false
    }
}