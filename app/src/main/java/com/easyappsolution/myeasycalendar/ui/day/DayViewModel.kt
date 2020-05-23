package com.easyappsolution.myeasycalendar.ui.day

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easyappsolution.myeasycalendar.ui.day.data.DayModel

class DayViewModel : ViewModel() {

    private val _text = MutableLiveData<DayModel>().apply {
        value = DayModel(
            "1",
            33,
            12,
            "martes",
            mutableListOf()
        )
    }
    val text: LiveData<DayModel> = _text
}