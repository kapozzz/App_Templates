package com.kapozzz.schedule_managment_platform.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.kapozzz.schedule_managment_platform.R
import com.kapozzz.schedule_managment_platform.domain.Article
import com.kapozzz.schedule_managment_platform.domain.Schedule
import com.kapozzz.schedule_managment_platform.domain.Subject
import com.kapozzz.schedule_managment_platform.screens.main.MainScreenViewModel
import com.kapozzz.ui_kit.AppTheme

@Composable
fun SubjectsList(
    lazyListState: LazyListState,
    viewModel: MainScreenViewModel,
    isExpanded: Boolean,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 24.dp,
                    topEnd = 24.dp
                )
            )
            .background(AppTheme.Palette.background)
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.padding(16.dp)
        ) {
            if (viewModel.subjects.value.isNotEmpty()) {
                item {
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = "Subjects",
                        style = AppTheme.BaseTypography.mediumTitle,
                        color = AppTheme.Palette.onBackground
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                        text = "Recommendations for you",
                        style = AppTheme.BaseTypography.smallTitle,
                        color = AppTheme.Palette.hint
                    )
                }
            }
            item {
                LazyRow {
                    items(viewModel.subjects.value) {
                        SubjectCard(
                            subject = it,
                            modifier = Modifier.padding(end = 8.dp),
                            onSubjectClick = {
                                openLink(context, it.aboutLink)
                            }
                        )
                    }
                }
            }
            if (viewModel.schedules.value.isNotEmpty()) {
                item {
                    Text(
                        modifier = Modifier.padding(top = 16.dp),
                        text = "Schedules",
                        style = AppTheme.BaseTypography.mediumTitle,
                        color = AppTheme.Palette.onBackground
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                        text = "Next lessons",
                        style = AppTheme.BaseTypography.smallTitle,
                        color = AppTheme.Palette.hint
                    )
                }
            }
            item {
                LazyRow {
                    items(viewModel.schedules.value) {
                        ScheduleCard(
                            schedule = it,
                            modifier = Modifier.padding(end = 8.dp),
                            onClick = {
                                openLink(context, it.meetingLink)
                            }
                        )
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "University News",
                    style = AppTheme.BaseTypography.mediumTitle,
                    color = AppTheme.Palette.onBackground
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
                    text = "Might be interesting",
                    style = AppTheme.BaseTypography.smallTitle,
                    color = AppTheme.Palette.hint
                )
            }
            items(viewModel.articles.value) {
                ArticleCard(
                    article = it,
                    modifier = Modifier.padding(bottom = 8.dp),
                    onClick = {
                        openLink(context, it.link)
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
        if (isExpanded) IconButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(AppTheme.Palette.secondaryContainer),
            onClick = { onClose() }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = AppTheme.Palette.onSecondaryContainer
            )
        }
    }
}

@Composable
fun ArticleCard(
    article: Article,
    onClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(300.dp)
            .fillMaxWidth()
            .background(AppTheme.Palette.primaryContainer)
            .clickable {
                onClick(article)
            },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = article.imageURL,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .height(80.dp)
                .fillMaxWidth()
                .background(AppTheme.Palette.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = article.name,
                style = AppTheme.BaseTypography.smallTitle,
                color = AppTheme.Palette.onPrimaryContainer, textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun ScheduleCard(
    schedule: Schedule,
    onClick: (Schedule) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(150.dp)
            .width(300.dp)
            .background(AppTheme.Palette.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.TopEnd),
            onClick = { onClick(schedule) }
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                painter = painterResource(id = R.drawable.link_icon),
                contentDescription = null,
                tint = AppTheme.Palette.onPrimaryContainer
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = schedule.subject.name,
                    style = AppTheme.BaseTypography.smallTitle,
                    color = AppTheme.Palette.onPrimaryContainer
                )
                Text(
                    text = schedule.theme,
                    style = AppTheme.BaseTypography.mediumBody,
                    color = AppTheme.Palette.onPrimaryContainer
                )
                Text(
                    text = schedule.location,
                    style = AppTheme.BaseTypography.mediumBody,
                    color = AppTheme.Palette.onPrimaryContainer
                )
                Text(
                    text = schedule.teacher,
                    style = AppTheme.BaseTypography.mediumBody,
                    color = AppTheme.Palette.onPrimaryContainer
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.padding(end = 4.dp),
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    tint = AppTheme.Palette.onPrimaryContainer
                )
                Text(
                    modifier = Modifier.padding(start = 4.dp),
                    text = schedule.dateInString(),
                    style = AppTheme.BaseTypography.mediumBody,
                    color = AppTheme.Palette.onPrimaryContainer
                )
            }
        }
    }
}

@Composable
fun SubjectCard(
    subject: Subject,
    onSubjectClick: (Subject) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .width(200.dp)
            .background(AppTheme.Palette.primaryContainer)
            .clickable { onSubjectClick(subject) },
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = subject.imageURI,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .height(IntrinsicSize.Min)
                .width(IntrinsicSize.Min)
                .clip(RoundedCornerShape(8.dp))
                .background(AppTheme.Palette.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = subject.name,
                style = AppTheme.BaseTypography.smallTitle,
                color = AppTheme.Palette.onPrimaryContainer, textAlign = TextAlign.Center
            )
        }
    }
}












