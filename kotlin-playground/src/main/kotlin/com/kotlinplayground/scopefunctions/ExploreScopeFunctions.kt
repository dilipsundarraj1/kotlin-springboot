package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory


fun main() {

    exploreApply()
    exploreAlso()
    exploreLet()
    exploreWith()
    exploreRun()


}

fun exploreRun() {

    var numbers : MutableList<Int>? = null
    val result = numbers.run {
        println("Inside run")
        numbers = mutableListOf(1,2,3)
        numbers?.sum()
    }
    println("result in Run : $result")

}

fun exploreWith() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = with(numbers) {
        println("Size is ${size}")
        plus(6)
        numbers.sum()
    }
    println("With result is : $result")

}

fun exploreLet() {
    val numbers = mutableListOf(1, 2, 3, 4, 5)
    val result = numbers.map { it * 2 }.filter { it > 5 }.let {
        println(it)
        it.sum()
        //println(it)
    }
    println("result: $result")

    var name: String? = null
    name = "Dilip"
    val result1 = name?.let { value ->
        println("Name is : $name")
        //it.length
        println("Length is ${value.length}")
        value.uppercase()
    }
    println("result1 : $result1")


}

fun exploreAlso() {

    val course = Course(
        1,
        "Design Thinking in Kotlin",
        "Dilip"
    )
        .apply {
            //this.courseCategory = CourseCategory.DESIGN
            courseCategory = CourseCategory.DESIGN
        }
        .also {
            println("Object is ready $it")
        }

    println("course is : $course")

}

private fun exploreApply() {
    val course = Course(
        1,
        "Design Thinking in Kotlin",
        "Dilip"
    )
        .apply {
            this.courseCategory = CourseCategory.DESIGN
        }

    println("course is : $course")
}