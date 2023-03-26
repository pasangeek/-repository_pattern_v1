package com.example.repository_pattern_v1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel :ViewModel(){
    private val _usersData = MutableLiveData<String>(null)
    val usersData: LiveData<String>
        get() = _usersData

    fun getUsers(){

        _usersData.value = "Test User"

    }


}