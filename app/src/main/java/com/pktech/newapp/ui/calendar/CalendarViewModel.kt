package com.pktech.myapp.calendar

import androidx.lifecycle.ViewModel
import com.pktech.myapp.data.model.CalendarDayModel
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

class CalendarViewModel : ViewModel() {

    fun getMonthCalendar(month: YearMonth): List<CalendarDayModel> {

        val list = mutableListOf<CalendarDayModel>()

        val firstDay = month.atDay(1)
        val totalDays = month.lengthOfMonth()

        for (i in 0 until totalDays) {
            val date = firstDay.plusDays(i.toLong())
            val day = date.dayOfWeek

            val isSunday = day == DayOfWeek.SUNDAY
            val saturdayIndex = getSaturdayIndex(date)

            val isHoliday =
                isSunday ||
                saturdayIndex == 2 ||
                saturdayIndex == 4

            val shiftType = calculateShift(date, isHoliday)

            list.add(
                CalendarDayModel(
                    date = date,
                    shift = shiftType,
                    isHoliday = isHoliday
                )
            )
        }

        return list
    }

    private fun calculateShift(date: LocalDate, isHoliday: Boolean): String {

        return when {
            isHoliday -> "HOLIDAY SHIFT"
            date.dayOfWeek.name in listOf("TUESDAY","WEDNESDAY","THURSDAY","FRIDAY") -> "FULL SHIFT"
            date.dayOfWeek.name == "MONDAY" -> "COMP-OFF RULE"
            date.dayOfWeek.name == "SATURDAY" -> "PARTIAL SHIFT"
            else -> "OFF"
        }
    }

    private fun getSaturdayIndex(date: LocalDate): Int {
        if (date.dayOfWeek != DayOfWeek.SATURDAY) return 0

        var count = 0
        var d = date.withDayOfMonth(1)

        while (d <= date) {
            if (d.dayOfWeek == DayOfWeek.SATURDAY) count++
            d = d.plusDays(1)
        }
        return count
    }
}