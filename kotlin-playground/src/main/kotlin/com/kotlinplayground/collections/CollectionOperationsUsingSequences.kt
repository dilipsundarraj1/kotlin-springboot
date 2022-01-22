package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {


    val namesListUsingSequence = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length >= 4 } // ["alex","chloe"]
        .map { it.uppercase() } // ["ALEX","CHLOE"]
        .toList()

    println("namesListUsingSequence : $namesListUsingSequence")

    val developmentCourses = filterCourses(courseList(), CourseCategory.DEVELOPEMENT)
    println("developmentCourses : $developmentCourses and devcourses size : ${developmentCourses.size}")

    val range = 1..1000_000_000
    range
        //.asSequence()
        .map { it.toDouble() }
        .take(40)
        .forEach {
            println("Value is : $it")
        }
}


private fun filterCourses(courseList: MutableList<Course>, courseCategory: CourseCategory): List<Course> {
    val courses = courseList
        .asSequence()
        .filter {
            it.category == courseCategory
        }
        .toList()
    return courses
}