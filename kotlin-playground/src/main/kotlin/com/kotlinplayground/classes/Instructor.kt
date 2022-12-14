package com.kotlinplayground.classes

data class Employee( val id: Int,
                       val name: String,)

fun main() {

    val employee = Employee(1, "Alex")
    println("employee : $employee")

    val employee1 = Employee(1, "Alex")

    println("Object Equality : ${employee==employee1}")

    val employee2 =  employee1.copy(
        id = 2
    )
    println("employee2 : $employee2")

}
