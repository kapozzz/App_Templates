package com.kapozzz.schedule_managment_platform.screens.main.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kapozzz.schedule_managment_platform.R
import com.kapozzz.ui_kit.AppTheme

@Composable
fun SubjectSearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    imageIsVisible: Boolean,
    modifier: Modifier = Modifier
) {
    val isEnabled = remember {
        mutableStateOf(false)
    }
    Box(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .height(52.dp)
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconButton(
                    modifier = Modifier
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(bottomEnd = 10.dp, topEnd = 10.dp))
                        .background(AppTheme.Palette.secondaryContainer),
                    onClick = {
                        isEnabled.value = !isEnabled.value
                        if (!isEnabled.value) onTextChange("")
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = if (!isEnabled.value) Icons.Default.Search else Icons.Default.Close,
                        contentDescription = null,
                        tint = AppTheme.Palette.onSecondaryContainer
                    )
                }
                AnimatedContent(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    targetState = isEnabled.value, label = ""
                ) { it ->
                    if (it) TextField(
                        value = text,
                        onValueChange = { onTextChange(it) },
                        textStyle = AppTheme.BaseTypography.mediumBody,
                        colors = TextFieldDefaults.colors(
                            focusedTextColor = AppTheme.Palette.onBackground,
                            unfocusedTextColor = AppTheme.Palette.onBackground,
                            focusedContainerColor = AppTheme.Palette.secondaryContainer,
                            unfocusedContainerColor = AppTheme.Palette.secondaryContainer,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        shape = RoundedCornerShape(10.dp)
                    )
                }
            }
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Nonexistent Some University",
                style = AppTheme.BaseTypography.largeTitle,
                color = AppTheme.Palette.onPrimary,
                textAlign = TextAlign.Center
            )
            AnimatedVisibility(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .align(Alignment.Start),
                visible = imageIsVisible,
                enter = fadeIn(),
                exit = fadeOut(animationSpec = tween(100))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.books_and_apple_icon),
                    contentDescription = null,
                )
            }
        }
    }
}