package com.kapozzz.schedule_managment_platform.domain.repositories

import com.kapozzz.schedule_managment_platform.domain.Schedule

interface ScheduleRepository {

    fun getSchedules(): List<Schedule>

    fun getSchedulesByDate(timestamp: Long): List<Schedule>

}