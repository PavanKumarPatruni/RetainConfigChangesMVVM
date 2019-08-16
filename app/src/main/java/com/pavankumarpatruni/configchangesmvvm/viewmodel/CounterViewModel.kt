package com.pavankumarpatruni.configchangesmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private var counter: MutableLiveData<Int> = MutableLiveData()

    fun getCounter(): LiveData<Int> {
        return counter
    }

    fun saveCounter(count: Int) {
        counter.value = count
    }

}