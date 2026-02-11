package com.pktech.newapp.data.local.dao

import androidx.room.*
import com.pktech.newapp.data.local.entity.ShiftEntity
import java.time.LocalDate

@Dao
interface ShiftDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ShiftEntity>)

    @Query("SELECT * FROM shifts WHERE employeeId=:empId")
    suspend fun getByEmployee(empId: Int): List<ShiftEntity>

    @Query("SELECT * FROM shifts WHERE date BETWEEN :start AND :end")
    suspend fun getByDateRange(start: LocalDate, end: LocalDate): List<ShiftEntity>

    @Query("DELETE FROM shifts")
    suspend fun clear()
}