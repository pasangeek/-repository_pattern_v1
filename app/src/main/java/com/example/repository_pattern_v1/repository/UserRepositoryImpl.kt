package com.example.repository_pattern_v1.repository

import android.util.Log
import com.example.repository_pattern_v1.model.User
import com.example.repository_pattern_v1.remote.ApiInterface
import com.example.repository_pattern_v1.remote.RetrofitClient

abstract class UserRepositoryImpl() : UserRepository{
    private lateinit var userService: ApiInterface


    init {
        initRetrofit()
    }


    private fun initRetrofit(){
        var retrofit = RetrofitClient.getInstance()
        userService = retrofit.create(ApiInterface::class.java)
    }
   override suspend fun getUsers(): List<User> {
            TODO("Not yet implemented")
        }

    private suspend  fun getUsersFromRemoteService(): List<User>{
        var users: List<User> = listOf()
        val response = userService.getUsers()
        if (response.isSuccessful) {
            val userResponse = response.body()
            users = userResponse?.data!!
            Log.d("LNBTI", "Remote user data fetching SUCCESSFUL users size: ${users.size}")
        }
        return users
    }

   fun getUsersFromLocalDb(){

        }




}