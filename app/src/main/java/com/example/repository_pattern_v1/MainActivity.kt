package com.example.repository_pattern_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.repository_pattern_v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   // val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    val viewModel: MyViewModel by lazy {
        val viewModelProviderFactory = UserViewModelProviderFactory()
        ViewModelProvider(this, viewModelProviderFactory)[MyViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Data binding
        binding.myVM = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener {

            viewModel.getUsers()
        }


        }



}