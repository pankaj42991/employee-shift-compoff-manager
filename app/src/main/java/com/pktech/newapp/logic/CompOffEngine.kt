package com.pktech.newapp.logic

class CompOffEngine {

    fun earn(shift: String, isHoliday: Boolean): Int {
        return if (isHoliday) 1 else 0
    }

    fun use(dayType: DayType): Int {
        return when (dayType) {
            DayType.MONDAY -> 1
            DayType.WEDNESDAY -> 1
            DayType.WORKING_SATURDAY -> 2
            else -> 0
        }
    }
}