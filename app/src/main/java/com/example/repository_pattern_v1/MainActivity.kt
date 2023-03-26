package com.example.repository_pattern_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.repository_pattern_v1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_main)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)



        //Data binding
        binding.myVM = viewModel
        binding.lifecycleOwner = this

binding.button.setOnClickListener {

    viewModel.getUsers()
}

    }
}