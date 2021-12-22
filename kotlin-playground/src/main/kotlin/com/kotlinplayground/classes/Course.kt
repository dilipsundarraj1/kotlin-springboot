package com.kotlinplayground.classes

data class Course(
    val id: Int,
    val name: String,
    val author: String,
)

fun main() {

    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    val course1 = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println("Is Course Equal ? : ${course == course1}")

    val course2 = course1.copy(
        id=2
    )
    println("Course 2 : $course2")
}
