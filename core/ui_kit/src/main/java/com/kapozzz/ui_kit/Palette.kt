package com.kapozzz.ui_kit


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalPalette = staticCompositionLocalOf<Palette> { error("palette was not initialized") }

data class Palette(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val tertiary: Color,
    val onTertiary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val hint: Color,
    val outline: Color,
    val error: Color
) {
    internal companion object {
        val defaultLightPalette = Palette(
            primary = darkBlue,
            onPrimary = gray,
            secondary = gravel,
            onSecondary = gray,
            tertiary = darkPurple,
            onTertiary = gray,
            primaryContainer = lightBlue,
            onPrimaryContainer = dark,
            secondaryContainer = secondLightBlue,
            onSecondaryContainer = dark,
            tertiaryContainer = lightPink,
            onTertiaryContainer = dark,
            background = gray,
            onBackground = dark,
            surface = lightGray,
            onSurface = dark,
            hint = mediumDarkGray,
            outline = darkGray,
            error = red
        )
    }
}