package com.easyappsolution.myeasycalendar.repos

import androidx.lifecycle.LiveData
import com.easyappsolution.myeasycalendar.repos.models.DayEvent

class EventsRepository(private val mSessionDao: DayEventDao) {

    fun getEventsOnDay(date:String): LiveData<List<DayEvent>> {
        return mSessionDao.getEventsByDate(
            date
        )
    }

    fun getEventsById(idEvent:String): LiveData<DayEvent> {
        return mSessionDao.getEventById(idEvent)
    }

    suspend fun insert(dayEvent: DayEvent) {
        mSessionDao.insert(
            dayEvent
        )
    }

    fun deleteUser() {
        mSessionDao.deleteAll()
    }

}