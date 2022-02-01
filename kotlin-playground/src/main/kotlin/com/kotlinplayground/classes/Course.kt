package com.kotlinplayground.classes

import com.kotlinplayground.CourseJava

data class Course  @JvmOverloads constructor (
    val id: Int,
    val name: String,
    val author: String,
    var courseCategory: CourseCategory = CourseCategory.DEVELOPEMENT
){

    @JvmField
    var noOfCourses = 10

    companion object {

        @JvmStatic
        fun printSomething() {

            println("Hello")
        }
    }
}


enum class CourseCategory{
    DEVELOPEMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}


@JvmName("printName1")
@JvmOverloads
fun printName(name : String = "default"){
    println("name : $name")
}

fun main() {

    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    val course1 = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println("Is CourseJava Equal ? : ${course == course1}")

    val course2 = course1.copy(
        id=2
    )
    println("CourseJava 2 : $course2")

    val  marketingCourse = Course(1, "FaceBook Marketing", "Dilip", CourseCategory.MARKETING)
    println("marketingCourse : $marketingCourse")

    val courseJava = CourseJava(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    courseJava.id = 1
    courseJava.name = "ABC"
    courseJava.author = "Dilip"

    courseJava.printCourse()

}
