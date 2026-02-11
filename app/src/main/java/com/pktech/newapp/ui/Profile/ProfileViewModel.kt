package com.pktech.newapp.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pktech.newapp.data.repository.ProfileRepository

class ProfileViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    fun getUserProfile(userId: Int) = liveData {
        emit(repository.getProfile(userId))
    }

    fun backupData() = liveData {
        emit(repository.backupData())
    }

    fun restoreData() = liveData {
        emit(repository.restoreData())
    }
}