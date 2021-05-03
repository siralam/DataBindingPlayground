package com.example.databindingtest

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class MainViewModel: ViewModel() {

    val userInput = MutableLiveData<String?>(null)
    val errorText = userInput.map { input ->
        if (input?.isBlank() == true) {
            "This field cannot be empty"
        } else {
            ""
        }
    }
    val isErrorVisible = errorText.map { errorText.value?.isNotBlank() == true }

    fun onReset() {
        userInput.value = null
    }


}