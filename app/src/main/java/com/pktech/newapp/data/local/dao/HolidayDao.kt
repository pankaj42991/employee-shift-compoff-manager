package com.pktech.newapp.data.local.dao

import androidx.room.*
import com.pktech.newapp.data.local.entity.HolidayEntity
import java.time.LocalDate

@Dao
interface HolidayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(holiday: HolidayEntity)

    @Query("SELECT * FROM holidays WHERE date=:date")
    suspend fun get(date: LocalDate): HolidayEntity?
}