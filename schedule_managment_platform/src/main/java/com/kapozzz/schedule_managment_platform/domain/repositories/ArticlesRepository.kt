package com.kapozzz.schedule_managment_platform.domain.repositories

import com.kapozzz.schedule_managment_platform.domain.Article

interface ArticlesRepository {
    fun getArticles(): List<Article>
}