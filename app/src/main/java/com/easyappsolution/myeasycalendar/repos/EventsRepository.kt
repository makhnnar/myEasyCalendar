package com.easyappsolution.myeasycalendar.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

class EventsRepository(private val mSessionDao: DayEventDao) {

    suspend fun getEventsOnDay(date:Long): List<DayEvent> {
        return mSessionDao.getEventsByDate(
            date
        )
    }

    fun getEventsById(idEvent:String): LiveData<DayEvent> {
        return mSessionDao.getEventById(idEvent)
    }

    suspend fun insert(dayEvent: DayEvent) : Long {
        return mSessionDao.insert(
            dayEvent
        )
    }

    fun deleteUser() {
        mSessionDao.deleteAll()
    }

}