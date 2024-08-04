package com.kapozzz.schedule_managment_platform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kapozzz.schedule_managment_platform.screens.main.MainScreen
import com.kapozzz.schedule_managment_platform.screens.main.MainScreenViewModel
import com.kapozzz.schedule_managment_platform.screens.main.mockArticlesRepository
import com.kapozzz.schedule_managment_platform.screens.main.mockScheduleRepository
import com.kapozzz.schedule_managment_platform.screens.main.mockSubjectsRepository
import com.kapozzz.schedule_managment_platform.ui.SchedulerTypography
import com.kapozzz.schedule_managment_platform.ui.lightPalette
import com.kapozzz.ui_kit.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            AppTheme(
                palette = lightPalette,
                baseTypography = SchedulerTypography
            ) {
                val viewModel = MainScreenViewModel(
                    mockScheduleRepository,
                    mockSubjectsRepository,
                    mockArticlesRepository
                )
                MainScreen(viewModel)
            }
        }
    }
}

