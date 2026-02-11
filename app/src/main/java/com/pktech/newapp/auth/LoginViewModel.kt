package com.pktech.newapp.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class LoginViewModel : ViewModel() {

    private val repo = AuthRepository()

    fun loginEmail(email: String, pass: String) = liveData {
        repo.loginWithEmail(email, pass) { success, msg ->
            emit(Pair(success, msg))
        }
    }
}