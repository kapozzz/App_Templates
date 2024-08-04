package com.kapozzz.schedule_managment_platform.domain.repositories

import com.kapozzz.schedule_managment_platform.domain.Subject

interface SubjectsRepository {

    fun getSubjects(): List<Subject>

}