package com.kapozzz.ui_kit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    palette: Palette = Palette.defaultLightPalette,
    baseTypography: BaseTypography = DefaultBaseTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalPalette provides palette,
        LocalBaseTypography provides baseTypography
    ) {
        content()
    }
}

object AppTheme {

    val Palette: Palette
        @Composable
        get() = LocalPalette.current

    val BaseTypography: BaseTypography
        @Composable
        get() = LocalBaseTypography.current

}