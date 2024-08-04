package com.kapozzz.ui_kit

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val LocalBaseTypography = staticCompositionLocalOf<BaseTypography> { error("type was not initialized") }

interface BaseTypography {

    val mediumTitle: TextStyle

    val smallTitle: TextStyle

    val mediumBody: TextStyle

    val largeTitle: TextStyle

}

internal object DefaultBaseTypography: BaseTypography {

    override val mediumTitle: TextStyle
        get() = TODO("Not yet implemented")
    override val smallTitle: TextStyle
        get() = TODO("Not yet implemented")
    override val mediumBody: TextStyle
        get() = TODO("Not yet implemented")
    override val largeTitle: TextStyle
        get() = TODO("Not yet implemented")


}