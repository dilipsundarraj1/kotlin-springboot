package com.kotlinplayground.exceptions

import java.io.File
import java.io.FileInputStream


fun returnNothing(): Nothing {
    throw RuntimeException("Exception")
}

fun nameLength(name: String?) = try {
    name!!.length
} catch (ex: Exception) {
    println("Exception is : $ex")
    null
}


fun main() {

    try {
        returnNothing()
    } catch (ex: Exception) {
        println("Exception is $ex")
    } finally {
        println("Finally Block")
    }

    println("Name Length is : ${nameLength("alex")}")
    println("Name Length is : ${nameLength(null)}")

    val file = File("file.txt")
    val stream = FileInputStream(file)

}