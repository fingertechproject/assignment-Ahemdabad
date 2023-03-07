package com.example.assignment.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assignment.UserInstance
import com.example.assignment.models.Data
import com.example.assignment.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel:ViewModel() {

    val dataList = MutableLiveData<List<Data>>()
    fun getUserData(page:Int){
        val userData = UserInstance.userInstance.getUserDetails(page)
        userData.enqueue(object : Callback<UserModel>{
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body()!=null) {
                    dataList.value = response.body()!!.data
                    Log.d("TAG", response.body()!!.data.toString())
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("TAG",t.toString())
            }
        })
    }
}