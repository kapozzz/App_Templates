package com.kapozzz.schedule_managment_platform.screens.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.kapozzz.schedule_managment_platform.screens.schedule.components.CurrentDayPicker
import com.kapozzz.schedule_managment_platform.screens.schedule.components.TodayDate
import com.kapozzz.ui_kit.AppTheme

@Composable
fun ScheduleScreen() {
    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.Palette.surface)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(configuration.screenHeightDp.dp - 120.dp - 16.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(AppTheme.Palette.background)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                TodayDate(modifier = Modifier
                    .height(120.dp)
                    .padding(bottom = 16.dp))
            }
            item {
                CurrentDayPicker(
                    currentDay =
                )
            }
        }
    }
}

