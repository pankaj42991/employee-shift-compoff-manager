package com.pktech.myapp.dashboard

import androidx.lifecycle.ViewModel
import com.pktech.myapp.data.local.AppDatabase

class DashboardViewModel : ViewModel() {

    // For demo: Hardcoded Admin
    fun isAdminUser(): Boolean {
        // Replace with actual login role check
        return true // Pankaj is admin
    }

    fun getTotalShifts(): Int {
        // Replace with Room DB query to count total shifts
        return 42
    }

    fun getTotalCompOff(): Int {
        // Replace with Room DB query to sum comp-off
        return 7
    }

    fun getTotalEmployees(): Int {
        // Replace with Room DB query to count employees
        return 6
    }
}