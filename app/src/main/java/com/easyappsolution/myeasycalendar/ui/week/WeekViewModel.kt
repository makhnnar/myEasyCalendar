package com.easyappsolution.myeasycalendar.ui.week

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyappsolution.myeasycalendar.ui.day.data.DayModel
import com.easyappsolution.myeasycalendar.ui.week.data.WeekModel

class WeekViewModel : ViewModel() {

    var weekData = MutableLiveData<WeekModel>()

    var isLoading = MutableLiveData<Boolean>().apply {
        value = false
    }

    //simulamos la llamada asincrona
    fun checkCurrentDay(){
        processBegin()
        object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }
            override fun onFinish() {
                weekData.postValue(
                    WeekModel(
                        "1",
                        12,
                        2,
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