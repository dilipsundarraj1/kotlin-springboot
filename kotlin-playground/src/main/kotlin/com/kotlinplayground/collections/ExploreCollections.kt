package com.kotlinplayground.collections

import com.kotlinplayground.dataset.courseList


fun main() {

    val names = listOf("Alex", "Ben", "Chloe")
    println("names : $names")
    val namesMutableList = mutableListOf("Alex", "Ben", "Chloe")

    namesMutableList.add("Adam")
    println("namesMutableList : $namesMutableList")


    val nameAgeMap = mapOf("dilip" to 33, "scooby" to 4)
    println("nameAgeMap : $nameAgeMap")

    val nameAgeMutableMap = mutableMapOf("dilip" to 33, "scooby" to 4)
    nameAgeMutableMap["abc"] = 100
    println("nameAgeMutableMap : $nameAgeMutableMap")

    val set = setOf("adam", "ben", "chloe")
    println("set: $set")

    val mutableSet = mutableSetOf("adam", "ben", "chloe")
    mutableSet.add("adam1")
    println("mutableSet :  $mutableSet")

    val add = { x: Int -> x + x }

    fun add(x:Int) = x+x

    listOf(1, 2, 3)
        .forEach {
            val result = add(it)
            println(result)
        }

    listOf(1, 2, 3)
        .forEach {
            val result = add(it)
            println(result)
        }


    val courses = courseList()
    courses
        .forEach { course ->
         //   println("course : $course")
        }

    courses
        .forEach {
        //    println("it : $it")
        }

}