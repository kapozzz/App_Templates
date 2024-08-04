package com.kapozzz.schedule_managment_platform.screens.schedule

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.kapozzz.schedule_managment_platform.domain.Schedule
import com.kapozzz.schedule_managment_platform.domain.repositories.ScheduleRepository

class ScheduleViewModel(
    private val scheduleRepository: ScheduleRepository
): ViewModel() {

    val currentDaySchedules = mutableStateOf<List<Schedule>>(emptyList())

    fun setSchedulesByDate(timestamp: Long) {
        currentDaySchedules.value = scheduleRepository.getSchedulesByDate(timestamp)
    }

}