package com.kapozzz.schedule_managment_platform.screens.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kapozzz.schedule_managment_platform.domain.Article
import com.kapozzz.schedule_managment_platform.domain.Schedule
import com.kapozzz.schedule_managment_platform.domain.Subject
import com.kapozzz.schedule_managment_platform.domain.isDateInRange
import com.kapozzz.schedule_managment_platform.domain.repositories.ArticlesRepository
import com.kapozzz.schedule_managment_platform.domain.repositories.ScheduleRepository
import com.kapozzz.schedule_managment_platform.domain.repositories.SubjectsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.sql.Timestamp

class MainScreenViewModel(
    private val scheduleRepository: ScheduleRepository,
    private val subjectsRepository: SubjectsRepository,
    private val mockArticlesRepository: ArticlesRepository
) : ViewModel() {

    val query = MutableStateFlow("")
    val schedules = mutableStateOf(
        scheduleRepository.getSchedules())
    val subjects =
        mutableStateOf(subjectsRepository.getSubjects())
    val articles = mutableStateOf(
        mockArticlesRepository.getArticles()
    )
    init {
        viewModelScope.launch {
            query.collect {
                if (query.value.isEmpty()) {
                    schedules.value = scheduleRepository.getSchedules()
                    subjects.value = subjectsRepository.getSubjects()
                    articles.value = mockArticlesRepository.getArticles()
                    return@collect
                }
                schedules.value = scheduleRepository.getSchedules().filter { it.subject.name.contains(query.value) }
                subjects.value = subjectsRepository.getSubjects().filter { it.name.contains(query.value) }
                articles.value = mockArticlesRepository.getArticles()
            }
        }
    }

}

val mockArticlesRepository = object : ArticlesRepository {
    override fun getArticles(): List<Article> {
        return listOf(
            Article(
                name = "Oxford chosen to help lead quantum computing research",
                imageURL = "https://ichef.bbci.co.uk/news/1024/cpsprodpb/d3a2/live/8a973240-4e8b-11ef-9117-4f95f4d16f69.jpg.webp",
                link = "https://www.bbc.com/news/articles/c4ngjxrrqygo"
            ),
            Article(
                name = "Oxford University research delves into origins of half-a-billion-year-old slug",
                imageURL = "https://s.yimg.com/ny/api/res/1.2/RrmYASKGmbXmbwCUtk9WWQ--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyNDI7aD04Mjg7Y2Y9d2VicA--/https://media.zenfs.com/en/oxford_mail_251/f903c9f5f332c4a8352550ca0cd104b3",
                link = "https://uk.news.yahoo.com/oxford-university-research-delves-origins-040000194.html?guccounter=1&guce_referrer=aHR0cHM6Ly9uZXdzLmdvb2dsZS5jb20v&guce_referrer_sig=AQAAAFDI3WDFdJMuLEzN4jR3FBBQsNGoNAxkn6c-B1cw3Hbp4-FeRaqwz7I2Xd1pdWvqrK8oqB771ErB6OIACHumgCtXxXPF7Dkxe7Nj2-t6CP-C5pNqg0slXo5-kMmyLbM0b0dhQtjOuYuAF6DiOT0vM7SaBhjEaL0wFvNowd_mGSFC"
            ),
            Article(
                name = "Oxford University switches from BMAT to BMSAT for admissions tests for Biomedical Science ",
                imageURL = "https://theoxfordblue.co.uk/wp-content/uploads/2024/07/biomed.jpeg",
                link = "https://theoxfordblue.co.uk/oxford-university-switches-from-bmat-to-bmsat-for-admissions-tests/"
            ),
        )
    }
}

val mockScheduleRepository = object : ScheduleRepository {
    override fun getSchedules(): List<Schedule> {
        val subjects = mockSubjectsRepository.getSubjects()
        return listOf(
            Schedule(
                subjects[0],
                theme = "Limits",
                location = "MSU",
                teacher = "Ivanov",
                timestamp = 1722710371,
                startTime = "10:00",
                endTime = "11:30",
                meetingLink = "https://zoom.us/ru"
            ),
            Schedule(
                subjects[1],
                theme = "WWII",
                location = "MSU",
                teacher = "Petrov",
                timestamp = 1722710371,
                startTime = "14:00",
                endTime = "15:30",
                meetingLink = "https://zoom.us/ru"
            ),
            Schedule(
                subjects[2],
                theme = "Alghoritms and Data Structures",
                location = "MSU",
                teacher = "Sidorov",
                timestamp = 1722710371,
                startTime = "17:00",
                endTime = "18:30",
                meetingLink = "https://zoom.us/ru"
            )
        )
    }
    override fun getSchedulesByDate(timestamp: Long): List<Schedule> {
        return getSchedules().filter { isDateInRange(timestamp, it.timestamp) }
    }
}

val mockSubjectsRepository = object : SubjectsRepository {
    override fun getSubjects(): List<Subject> {
        return listOf(
            Subject(
                name = "Math",
                imageURI = "https://avatars.mds.yandex.net/i?id=af91d37c5b4cdc49166fdb078cb71f5d_l-5875357-images-thumbs&n=13",
                aboutLink = "https://en.wikipedia.org/wiki/Mathematics"
            ),
            Subject(
                name = "History",
                imageURI = "https://avatars.mds.yandex.net/i?id=e0cd079bb056c94a5428750f9966c449_l-4010805-images-thumbs&n=13",
                aboutLink = "https://en.wikipedia.org/wiki/History"
            ),
            Subject(
               name = "Programming",
                imageURI = "https://avatars.mds.yandex.net/i?id=6530e9173df64cd01dc3c7ec4e2a5b36ab5d2430-10931100-images-thumbs&n=13",
                aboutLink = "https://en.wikipedia.org/wiki/Computer_programming"
            )
        )
    }
}