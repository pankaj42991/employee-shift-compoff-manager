package com.pktech.newapp.logic

import java.time.LocalDate

class ShiftGenerator(private val employees: List<Int>) {

    private var nightIndex = 0

    fun generate(date: LocalDate): Map<Int, String> {

        val map = mutableMapOf<Int, String>()
        val dayType = DateRuleEngine.getDayType(date)

        when (dayType) {

            DayType.WORKING_DAY -> assignWeekday(map)

            DayType.MONDAY -> assignMonday(map)

            DayType.WEDNESDAY -> assignWednesday(map)

            DayType.WORKING_SATURDAY -> assignWorkingSaturday(map)

            DayType.SECOND_SATURDAY,
            DayType.FOURTH_SATURDAY,
            DayType.SUNDAY,
            DayType.FESTIVAL -> assignHoliday(map)
        }

        return map
    }

    private fun assignWeekday(map: MutableMap<Int, String>) {
        map[employees[0]] = "MORNING"

        var i = 1
        map[employees[i++]] = "GENERAL"
        map[employees[i++]] = "GENERAL"
        map[employees[i++]] = "MID"
        map[employees[i++]] = "SECOND"

        map[employees[nightIndex]] = "NIGHT"
        rotateNight()
    }

    private fun assignMonday(map: MutableMap<Int, String>) {
        map[employees[0]] = "MORNING"
        map[employees[1]] = "GENERAL"
        map[employees[2]] = "GENERAL"
        map[employees[3]] = "SECOND"
        map[employees[nightIndex]] = "NIGHT"
        rotateNight()
    }

    private fun assignWednesday(map: MutableMap<Int, String>) {
        map[employees[0]] = "MORNING"
        map[employees[1]] = "GENERAL"
        map[employees[2]] = "GENERAL"
        map[employees[3]] = "SECOND"
        map[employees[nightIndex]] = "NIGHT"
        rotateNight()
    }

    private fun assignWorkingSaturday(map: MutableMap<Int, String>) {
        map[employees[0]] = "MORNING"
        map[employees[1]] = "GENERAL"
        map[employees[2]] = "SECOND"
        map[employees[nightIndex]] = "NIGHT"
        rotateNight()
    }

    private fun assignHoliday(map: MutableMap<Int, String>) {
        map[employees[nightIndex]] = "NIGHT"
        map[employees[(nightIndex + 1) % employees.size]] = "DAY"
        rotateNight()
    }

    private fun rotateNight() {
        nightIndex = (nightIndex + 1) % employees.size
    }
}