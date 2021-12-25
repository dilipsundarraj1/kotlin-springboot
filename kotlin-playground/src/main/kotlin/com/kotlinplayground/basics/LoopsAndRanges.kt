package com.kotlinplayground.basics

fun main() {
    val range = 1..10
    for (i in range){
        println(i)
    }

    val reverseRange = 10 downTo 1
    for (i in reverseRange){
        println(i)
    }
    for (i in reverseRange step 2){
        println(i)
    }
    exploreWhile()
    exploreDoWhile()

    for (i in range){
        if(i==3) break
        println("Value before break : $i")
    }
}


fun exploreDoWhile() {
    var i = 0
    do {
        println("Inside do while : $i")
        i++
    }while (i < 5)
}

fun exploreWhile() {
    var x = 1
    while(x < 5){
        println("Value of x is $x")
        x++
    }
}
