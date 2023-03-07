package com.example.assignment

import com.example.assignment.models.Data
import com.example.assignment.models.UserModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query


const val DELETE_OR_UPDATE_USER = "/users/{user_id}"
const val GET_ALL_USERS = "/users"
const val BASE_URL = "https://reqres.in/api"

interface ApiInterface{

    @GET(GET_ALL_USERS)
    fun getUserDetails(@Query("page")page:Int):Call<UserModel>

    @DELETE(DELETE_OR_UPDATE_USER)
    fun deleteUser(@Path("user_id") user_id:Int):Call<UserModel>

    @PATCH(DELETE_OR_UPDATE_USER)
    fun updateUser(@Path("user_id") user_id:Int):Call<UserModel>
}

object UserInstance{
    val userInstance:ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        userInstance = retrofit.create(ApiInterface::class.java)
    }
}