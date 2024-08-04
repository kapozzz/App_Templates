package com.kapozzz.schedule_managment_platform.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kapozzz.schedule_managment_platform.R
import com.kapozzz.ui_kit.BaseTypography

val helveticaBold = FontFamily(
    Font(R.font.helvetica_bold, FontWeight.Normal)
)

val helveticaLight = FontFamily(
    Font(R.font.helvetica_light, FontWeight.Normal)
)

val university = FontFamily(
    Font(R.font.university, FontWeight.Normal)
)

object SchedulerTypography: BaseTypography {

    override val mediumTitle = TextStyle(
        fontFamily = helveticaBold,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.5.sp
    )

    override val smallTitle = TextStyle(
        fontFamily = helveticaBold,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    )

    override val mediumBody = TextStyle(
        fontFamily = helveticaLight,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.5.sp
    )
    override val largeTitle: TextStyle =  TextStyle(
        fontFamily = university,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp
    )


}
