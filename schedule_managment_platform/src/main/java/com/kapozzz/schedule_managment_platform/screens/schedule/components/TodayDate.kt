package com.kapozzz.schedule_managment_platform.screens.schedule.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kapozzz.ui_kit.AppTheme
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun TodayDate(
    modifier: Modifier = Modifier
) {
    val formatedDate = SimpleDateFormat("dd-MM-yyyy", LocalConfiguration.current.locale)
    val (day, month, year) = formatedDate.format(Date()).split("-")
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = day,
                style = AppTheme.BaseTypography.mediumTitle,
                color = AppTheme.Palette.onBackground,
                fontSize = 26.sp
            )
            Text(
                text = ".$month.$year",
                style = AppTheme.BaseTypography.mediumBody,
                color = AppTheme.Palette.hint,
                fontSize = 20.sp
            )
        }
        Box(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .width(IntrinsicSize.Min)
                .clip(RoundedCornerShape(4.dp))
                .background(AppTheme.Palette.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Today",
                style = AppTheme.BaseTypography.mediumTitle,
                color = AppTheme.Palette.onPrimaryContainer,
                fontSize = 26.sp
            )
        }
    }
}

@Composable
@Preview
private fun TodayDatePreview() {
    AppTheme {
        TodayDate()
    }
}