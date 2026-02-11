package com.pktech.newapp.data.repository

import com.pktech.newapp.data.local.dao.ShiftDao
import com.pktech.newapp.data.local.entity.ShiftEntity

class ShiftRepository(private val dao: ShiftDao) {

    suspend fun saveShifts(list: List<ShiftEntity>) {
        dao.insertAll(list)
    }

    suspend fun getEmployeeShifts(empId: Int) = dao.getByEmployee(empId)
}