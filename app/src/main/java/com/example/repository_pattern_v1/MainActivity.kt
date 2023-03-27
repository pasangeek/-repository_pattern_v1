package com.example.repository_pattern_v1

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.repository_pattern_v1.databinding.ActivityMainBinding
import com.example.repository_pattern_v1.local.UserDatabase
import com.example.repository_pattern_v1.remote.ApiInterface
import com.example.repository_pattern_v1.remote.RetrofitClient
import com.example.repository_pattern_v1.repository.UserRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

   // val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Retrofit
        UserApp.retrofit = RetrofitClient.getInstance()
        // Room
        UserApp.userDatabase = UserDatabase.getInstance(applicationContext)
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Data binding
        binding.myVM = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {

            viewModel.getUsers()
        }


        }





    class UserApp : Application() {

        companion object {
            // Retrofit
            lateinit var retrofit: Retrofit
            // Room
            lateinit var userDatabase: UserDatabase
        }



    }
    class UserViewModelProviderFactory() : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            val userDao = UserApp.userDatabase.userDao()
            val userService = UserApp.retrofit.create(ApiInterface::class.java)
            val userRepository = UserRepositoryImpl(userDao = userDao, userService = userService)

            val viewModel = MyViewModel(userRepository)

            return viewModel as T
        }



    }

    val viewModel: MyViewModel by lazy {
        val viewModelProviderFactory = UserViewModelProviderFactory()
        ViewModelProvider(this, viewModelProviderFactory)[MyViewModel::class.java]
    }

}