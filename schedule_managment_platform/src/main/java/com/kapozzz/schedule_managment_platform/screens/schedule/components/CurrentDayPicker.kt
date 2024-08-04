package com.kapozzz.schedule_managment_platform.screens.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.kapozzz.ui_kit.AppTheme
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Date

//@Composable
//fun CurrentDayPicker(
//    timestamp: Long,
//    onDayClick: (Long) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val formatedDate = SimpleDateFormat("dd-MM-yyyy", LocalConfiguration.current.locale)
//    val (day, month, year) = formatedDate.format(Date()).split("-")
//    val days = mutableListOf<Int>()
//    for (i in -3..3) {
//        days.add((day.toInt() + i - 1) % 31 + 1)
//    }
//    Row(
//        modifier = Modifier
//            .fillMaxWidth(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceEvenly
//    ) {
//        days.forEach {
//            DayItem(day = it, onDayClick = onDayClick, timestamp = timestamp)
//        }
//    }
//}
//
//@Composable
//private fun DayItem(
//    day: Long,
//    timestamp: Long,
//    onDayClick: (Long) -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Box(
//        modifier = Modifier
//            .height(60.dp)
//            .width(30.dp)
//            .clip(RoundedCornerShape(8.dp))
//            .background(if (timestamp == day) AppTheme.Palette.secondary else AppTheme.Palette.background),
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "$day",
//            style = AppTheme.BaseTypography.mediumTitle,
//            color = if (timestamp == day) AppTheme.Palette.onSecondary else AppTheme.Palette.background
//        )
//    }
//}
