package com.kotlinplayground.basics

import com.kotlinplayground.functions.courseName
import com.kotlinplayground.functions.topLevelFunction


fun main() {

    //val name : String = "Dilip"
    val name = "Dilip"

    //name = "d" // this is not allowed for a variable thats declared as val type
    println(name)

    var age : Int = 33
    age = 34
    println(age)

    val salary = 30000L
    println(salary)

    val num : Double = 30000.056667
    println(num)

    val course = "Kotlin Spring"
    println("course : $course and the length of the course is ${course.length}")

    val multiLine = "ABC \n DEF"
    println("multiLine : $multiLine")


    val multiLine1 ="""
        ABC
        DEF
    """.trimIndent()

    println("multiLine1 : $multiLine1")

    topLevelFunction()
    println("courseName : $courseName")
}