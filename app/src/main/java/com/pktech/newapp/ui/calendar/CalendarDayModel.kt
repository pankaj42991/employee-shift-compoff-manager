package com.pktech.myapp.data.model

import java.time.LocalDate

data class CalendarDayModel(
    val date: LocalDate,
    val shift: String,
    val isHoliday: Boolean
)