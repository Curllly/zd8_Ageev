package com.example.individultask

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.util.Log
import java.lang.IllegalArgumentException

class MainViewModel(application: Application) : AndroidViewModel(application) {
    fun initDatabase() {
        Log.d("checkData", "MainViewModel init database")
    }
}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(application = application) as T
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}