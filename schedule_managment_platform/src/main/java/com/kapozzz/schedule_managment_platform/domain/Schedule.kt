package com.kapozzz.schedule_managment_platform.domain

import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

data class Schedule(
    val subject: Subject,
    val theme: String,
    val location: String,
    val teacher: String,
    val timestamp: Long,
    val startTime: String,
    val endTime: String,
    val meetingLink: String
) {
    fun dateInString(): String {
        val zonedDateTime = ZonedDateTime.ofInstant(java.time.Instant.ofEpochMilli(timestamp), ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return zonedDateTime.format(formatter)
    }
}

fun isDateInRange(firstDate: Long, secondDate: Long): Boolean {
    val firstInstant = Instant.ofEpochMilli(firstDate)
    val secondInstant = Instant.ofEpochMilli(secondDate)
    val startRange = firstInstant.minus(3, ChronoUnit.DAYS)
    val endRange = firstInstant.plus(3, ChronoUnit.DAYS)
    return !secondInstant.isBefore(startRange) && !secondInstant.isAfter(endRange)
}
