package com.kotlinplayground.collections

fun main() {

    val namesArray = arrayOf("alex","ben", "chloe")
    val newNamesArray = namesArray.plus("adam")
    println("namesArray : ${namesArray.size}")
    println("newNamesArray : ${newNamesArray.size}")

    val filteredArray = namesArray.filter {
        it.length >= 4
    }
    println("filteredArray : $filteredArray")

    val toArray = filteredArray.toTypedArray()
    println("toArray : $toArray")


    val emptyArray= emptyArray<String>()
    val newArray = emptyArray.plus("abc")


    emptyArray.forEach {
        println("Value is : $it")
    }
    println("emptyArray : $emptyArray")

    newArray.forEach {
        println("Value is : $it")
    }
    println("newArray : $newArray")



}