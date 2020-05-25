package com.easyappsolution.myeasycalendar.ui.day

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyappsolution.myeasycalendar.ui.day.data.DayModel

class DayViewModel : ViewModel() {

    var dayData =  MutableLiveData<DayModel>()

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
                dayData.postValue(
                    DayModel(
                        "1",
                        33,
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