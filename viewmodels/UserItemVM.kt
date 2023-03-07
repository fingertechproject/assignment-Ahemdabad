package com.example.assignment.viewmodels

import android.database.Observable
import androidx.databinding.ObservableField

class UserItemVM {
    val firstName= ObservableField("Jhon")
    val lastName = ObservableField("martin")
    val email = ObservableField("jhonmartin@gmail.com")

}