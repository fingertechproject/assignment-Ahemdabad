package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.assignment.adapter.UserAdapter
import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.viewmodels.MainViewModel
class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
  /*  val adapter:UserAdapter by lazy {
        UserAdapter(this, mutableListOf())
    }*/
    lateinit var adapter:UserAdapter
    val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel.getUserData(1)
        viewModel.dataList.observe(this, Observer {
            adapter = UserAdapter(this,it)
        })
    }
}