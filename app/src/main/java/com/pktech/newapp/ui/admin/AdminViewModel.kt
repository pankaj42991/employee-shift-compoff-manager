package com.pktech.newapp.ui.admin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pktech.newapp.data.repository.AdminRepository
import java.time.LocalDate

class AdminViewModel(
    private val repository: AdminRepository
) : ViewModel() {

    fun getEmployees() = liveData {
        emit(repository.getEmployees())
    }

    fun addHoliday(date: LocalDate, name: String, isWorking: Boolean) = liveData {
        emit(repository.addHoliday(date, name, isWorking))
    }

    fun overrideShift(empId: Int, date: LocalDate, shift: String) = liveData {
        emit(repository.overrideShift(empId, date, shift))
    }

    fun regenerateSchedule(month: Int, year: Int) = liveData {
        emit(repository.regenerateSchedule(month, year))
    }
}