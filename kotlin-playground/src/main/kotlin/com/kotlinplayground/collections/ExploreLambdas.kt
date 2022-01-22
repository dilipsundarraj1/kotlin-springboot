package com.kotlinplayground.collections

/**
 * Higher Order Function
 */
fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

fun main() {

    val addLambda = { x: Int -> x * x }

    val addResult = addLambda(3)
    println(addResult)


    val multiplyLambda = { x: Int, y: Int ->
        println("Input arguments are x: $x and y : $y")
        x * y
    }

    val multiplyResult = multiplyLambda(2, 3)
    println(multiplyResult)

    val numbers = listOf(1, 2, 3)
    numbers
        .forEach {
            println("it in first line: ${addLambda(it)}")
            println("it second line : $it")
        }

    val result = calculate(2, 3) { a, b -> a * b }
    println("Result : $result")

    val add = calculate(2, 3) { a, b -> a + b }
    println("add : $add")
}