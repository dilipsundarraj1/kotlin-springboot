package com.kotlinplayground.functions

import java.time.LocalDate

//fun printHello(){
fun printHello() : Unit {
    println("Hello!")
}


fun returnNothing() : Nothing {
    throw RuntimeException("Exception")
}

fun printName(name: String){
    println("Name is $name")
}

fun addition(x: Int, y : Int): Int {
    return x+y
}

/**
 * Use this only if the whole method is an expression
 * This is concise and you can avoid the redundant return statement
 */
fun addition_approach1(x: Int, y : Int) = x+y

fun printPersonDetails(name : String, email : String = "", dob : LocalDate = LocalDate.now()){

    println("Name is $name and the email is $email and the dob is $dob")
}


/**
 *
 * This just accepts arbitary number of arguments
 */
fun printMultipleThings(vararg  alphabets: String){
    println("strings : $alphabets")
    for(alphabet in alphabets ){
        println(alphabet)
    }

    //val alphabetList = listOf(alphabets)
    val alphabetList = listOf(*alphabets) // this is also called spread operator
    println("alphabetList : $alphabetList")

}

fun main() {
    printHello()
    printName("Dilip")
    val result = addition(2,3)
    println("Result is $result")

    val result2 = addition_approach1(2,3)
    println("Result is $result2")
    printMultipleThings("A", "B", "C")
    printPersonDetails("Dilip", "abc@gmail.com" , LocalDate.parse("2000-01-01") )
    printPersonDetails("Dilip")
    printPersonDetails("Dilip", dob = LocalDate.parse("2000-01-01") )
    printPersonDetails(dob = LocalDate.parse("2000-01-01") , name = "Dilip", email = "abc@gmail.com")

    returnNothing()
}