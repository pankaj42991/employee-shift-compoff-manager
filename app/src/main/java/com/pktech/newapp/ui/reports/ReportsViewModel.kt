package com.pktech.newapp.ui.reports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.pktech.newapp.data.repository.ReportRepository

class ReportsViewModel(
    private val repository: ReportRepository
) : ViewModel() {

    fun getMonthlyReport(employeeId: Int, month: Int, year: Int) = liveData {
        emit(repository.getMonthlyReport(employeeId, month, year))
    }

    fun getYearlyReport(employeeId: Int, year: Int) = liveData {
        emit(repository.getYearlyReport(employeeId, year))
    }
}