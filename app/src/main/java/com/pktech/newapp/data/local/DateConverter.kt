package com.pktech.newapp.data.local

import androidx.room.TypeConverter
import java.time.LocalDate

class DateConverter {

    @TypeConverter
    fun fromDate(date: LocalDate): String = date.toString()

    @TypeConverter
    fun toDate(value: String): LocalDate = LocalDate.parse(value)
}