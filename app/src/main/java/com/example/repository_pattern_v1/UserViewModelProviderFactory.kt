package com.example.repository_pattern_v1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repository_pattern_v1.remote.ApiInterface
import com.example.repository_pattern_v1.repository.UserRepositoryImpl

class UserViewModelProviderFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val userDao = UserApp.userDatabase.userDao()
        val userService = UserApp.retrofit.create(ApiInterface::class.java)
        val userRepository = UserRepositoryImpl(userDao = userDao, userService = userService)

        val viewModel = MyViewModel(userRepository)

        return viewModel as T
    }



}