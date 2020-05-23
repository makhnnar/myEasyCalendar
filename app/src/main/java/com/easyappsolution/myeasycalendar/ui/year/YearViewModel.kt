package com.easyappsolution.myeasycalendar.ui.year

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class YearViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Year Fragment"
    }
    val text: LiveData<String> = _text

}