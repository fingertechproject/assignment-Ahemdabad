package com.example.assignment.viewmodels

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.assignment.UserInstance
import com.example.assignment.models.Data
import com.example.assignment.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserFullDataVM(val context: Context):ViewModel() {
    var data:Data? = null
    val firstName= ObservableField("Jhon")
    val lastName = ObservableField("martin")
    val email = ObservableField("jhonmartin@gmail.com")

    fun deleteUser(id:Int){
        val userData = UserInstance.userInstance.deleteUser(id)
        userData.enqueue(object : Callback<UserModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body()!=null)
                    Log.d("TAG", response.body()!!.data.toString())
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("TAG",t.toString())
            }
        })
    }
    fun updateUser(id:Int){
        val userData = UserInstance.userInstance.updateUser(id)
        userData.enqueue(object : Callback<UserModel> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                if (response.body()!=null)
                    Log.d("TAG", response.body()!!.data.toString())
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.d("TAG",t.toString())
            }
        })
    }
    fun setAllData(){
        if (data!=null) {
            firstName.set(data!!.first_name)
            lastName.set(data!!.last_name)
            email.set(data!!.email)
        }
    }
}