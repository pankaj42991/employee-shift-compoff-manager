package com.pktech.newapp.data.local.dao

import androidx.room.*
import com.pktech.newapp.data.local.entity.EmployeeEntity

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: EmployeeEntity)

    @Query("SELECT * FROM employees")
    suspend fun getAll(): List<EmployeeEntity>

    @Query("SELECT * FROM employees WHERE id=:id")
    suspend fun getById(id: Int): EmployeeEntity
}