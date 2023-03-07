package com.example.assignment

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.assignment.databinding.ActivityUserFullDataBinding
import com.example.assignment.models.Data
import com.example.assignment.viewmodels.MainViewModel
import com.example.assignment.viewmodels.UserFullDataVM

class UserFullDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserFullDataBinding
    private var data:Data? = null
    val viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
        UserFullDataVM::class.java)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserFullDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.extras!=null && intent.hasExtra("DATA"))
        viewModel.data = intent.extras!!.getParcelable("DATA",Data::class.java)

        if(data!=null)
        binding.firstName.text = data!!.first_name
        binding.lastName.text = data!!.last_name
        binding.email.text = data!!.email
        Glide.with(this).load(data!!.avatar).into(binding.userFullImage)

        binding.deleteBtn.setOnClickListener {
            if (data!=null)
           viewModel.deleteUser(data!!.id)
        }
        binding.updtBtn.setOnClickListener {
        if (data!=null)
            viewModel.updateUser(data!!.id)
        }
    }



}