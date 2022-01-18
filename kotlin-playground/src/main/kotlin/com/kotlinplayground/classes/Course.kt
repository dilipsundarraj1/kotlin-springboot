package com.kotlinplayground.classes

data class Course(
    val id: Int,
    val name: String,
    val author: String,
    var courseCategory: CourseCategory = CourseCategory.DEVELOPEMENT
)

enum class CourseCategory{
    DEVELOPEMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {

    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    val course1 = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println("Is Course Equal ? : ${course == course1}")

    val course2 = course1.copy(
        id=2
    )
    println("Course 2 : $course2")

    val  marketingCourse = Course(1, "FaceBook Marketing", "Dilip", CourseCategory.MARKETING)
    println("marketingCourse : $marketingCourse")

}
