package com.kotlinplayground.collections

/**
 * Higher Order Function
 */
fun calculate(x: Int, op: (x: Int) -> Int): Int {
        return op(x)
}

fun main() {

    val addLambda = { x: Int -> x + x }

    val numbers = listOf(1, 2, 3)

    numbers
        .forEach {
            println("it in first line: ${addLambda(it)}")
            println("it second line : $it")
        }


    val result = calculate(2) { x -> x * x }
    println("Result : $result")

    val add = calculate(2) { x -> x + x }
    println("add : $add")
}