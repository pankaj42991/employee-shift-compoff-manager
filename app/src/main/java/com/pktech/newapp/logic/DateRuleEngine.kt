package com.pktech.newapp.logic

import java.time.DayOfWeek
import java.time.LocalDate

object DateRuleEngine {

    fun getDayType(date: LocalDate): DayType {

        return when (date.dayOfWeek) {
            DayOfWeek.SUNDAY -> DayType.SUNDAY

            DayOfWeek.SATURDAY -> {
                when ((date.dayOfMonth - 1) / 7 + 1) {
                    2 -> DayType.SECOND_SATURDAY
                    4 -> DayType.FOURTH_SATURDAY
                    else -> DayType.WORKING_SATURDAY
                }
            }

            DayOfWeek.MONDAY -> DayType.MONDAY
            DayOfWeek.WEDNESDAY -> DayType.WEDNESDAY
            else -> DayType.WORKING_DAY
        }
    }
}

enum class DayType {
    WORKING_DAY,
    MONDAY,
    WEDNESDAY,
    WORKING_SATURDAY,
    SECOND_SATURDAY,
    FOURTH_SATURDAY,
    SUNDAY,
    FESTIVAL
}