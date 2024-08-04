package com.kapozzz.schedule_managment_platform.screens.main

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.kapozzz.schedule_managment_platform.screens.main.components.SubjectSearchBar
import com.kapozzz.schedule_managment_platform.screens.main.components.SubjectsList
import com.kapozzz.ui_kit.AppTheme
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel
) {
    val localConfiguration = LocalConfiguration.current
    val screenHeight = localConfiguration.screenHeightDp
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.Palette.primary)

    ) {
        val internalContentScrollState = rememberLazyListState()
        val derivedContentScrollState = remember {
            derivedStateOf {
                internalContentScrollState.firstVisibleItemIndex > 0
            }
        }
        val isExpanded = remember {
            mutableStateOf(false)
        }
        val scope = rememberCoroutineScope()
        if (derivedContentScrollState.value) isExpanded.value = true
        val listContentHeight = animateIntAsState(
            targetValue = (screenHeight * if (isExpanded.value) 0.9 else 0.6).toInt(),
            label = "",
            animationSpec = tween(300)
        )
        val query = viewModel.query.collectAsState()
        SubjectSearchBar(
            text = query.value,
            onTextChange = { viewModel.query.value = it },
            modifier = Modifier
                .height((screenHeight - listContentHeight.value).dp)
                .padding(top = 16.dp, end = 4.dp),
            imageIsVisible = !derivedContentScrollState.value
        )
        SubjectsList(
            lazyListState = internalContentScrollState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .height(listContentHeight.value.dp - if (isExpanded.value) 16.dp else 0.dp),
            viewModel = viewModel,
            isExpanded = isExpanded.value,
            onClose = {
                scope.launch {
                    internalContentScrollState.animateScrollToItem(0)
                    isExpanded.value = false
                }
            }
        )
    }
}





