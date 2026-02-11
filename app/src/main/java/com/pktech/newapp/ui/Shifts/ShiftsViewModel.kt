package com.pktech.myapp.shifts

import androidx.lifecycle.ViewModel
import com.pktech.myapp.data.local.AppDatabase
import com.pktech.myapp.data.local.entities.ShiftEntity
import java.time.LocalDate

class ShiftsViewModel : ViewModel() {

    // Hardcoded for demo, replace with login user role check
    fun isAdminUser(): Boolean {
        return true // Pankaj = Admin
    }

    // Get shifts for a week (Excel logic implemented)
    fun getShiftsForWeek(): List<ShiftEntity> {
        // TODO: Replace with Room DB query
        val shifts = mutableListOf<ShiftEntity>()
        val employees = listOf("Pankaj","Akash","Ankush","Chandu","Vikrant","Sanni")
        val today = LocalDate.now()

        for (i in 0..6) {
            val date = today.plusDays(i.toLong())
            shifts.add(ShiftEntity(1, employees[0], date.toString(), "Morning", false, false))
            shifts.add(ShiftEntity(2, employees[1], date.toString(), "General", false, false))
            shifts.add(ShiftEntity(3, employees[2], date.toString(), "General", false, false))
            shifts.add(ShiftEntity(4, employees[3], date.toString(), "Second", false, false))
            shifts.add(ShiftEntity(5, employees[4], date.toString(), "Night", false, false))
        }
        return shifts
    }

    // Auto-rotate night shift among employees weekly
    fun autoRotateNightShift() {
        // TODO: Implement full rotation logic based on Excel
    }
}