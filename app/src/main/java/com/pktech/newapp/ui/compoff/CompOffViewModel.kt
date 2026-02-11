package com.pktech.newapp.ui.compoff

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pktech.newapp.data.repository.CompOffRepository

class CompOffViewModel(
    private val repository: CompOffRepository
) : ViewModel() {

    fun getEmployeeCompOff(employeeId: Int) = liveData {
        emit(repository.getCompOffSummary(employeeId))
    }

    fun addEarn(employeeId: Int, count: Int, reason: String) {
        repository.addEarn(employeeId, count, reason)
    }

    fun addUsage(employeeId: Int, count: Int, reason: String) {
        repository.addUsage(employeeId, count, reason)
    }

    fun calculateCarryForward(employeeId: Int) {
        repository.calculateCarryForward(employeeId)
    }
}