package com.pktech.newapp.data.local.dao

import androidx.room.*
import com.pktech.newapp.data.local.entity.CompOffEntity

@Dao
interface CompOffDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CompOffEntity)

    @Query("SELECT * FROM comp_off WHERE employeeId=:empId")
    suspend fun get(empId: Int): CompOffEntity?
}