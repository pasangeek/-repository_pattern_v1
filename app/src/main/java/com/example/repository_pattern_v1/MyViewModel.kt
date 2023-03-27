package com.example.repository_pattern_v1

import android.app.Application
import androidx.lifecycle.*
import com.example.repository_pattern_v1.local.UserDatabase
import com.example.repository_pattern_v1.remote.ApiInterface
import com.example.repository_pattern_v1.remote.RetrofitClient
import com.example.repository_pattern_v1.repository.UserRepository
import com.example.repository_pattern_v1.repository.UserRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MyViewModel(private val userRepo: UserRepository) :ViewModel(){
    //private val userRepo: UserRepositoryImpl
    private val _usersData = MutableLiveData<String>(null)
    val usersData: LiveData<String>
        get() = _usersData


    init {
       // val userDao = UserDatabase.getInstance(application).userDao()
       // userRepo = UserRepositoryImpl(userDao)
    }
    fun getUsers(){

        viewModelScope.launch {
            val users = userRepo.getUsers()

            var strUser: String? = null
            var userRecord = ""
            for (user in users)
                strUser = "${user.id} \n$user.firstName \n$user.lastName \n$user.email\n\n"

            userRecord += strUser

            _usersData.value = userRecord
        }


    }



}



