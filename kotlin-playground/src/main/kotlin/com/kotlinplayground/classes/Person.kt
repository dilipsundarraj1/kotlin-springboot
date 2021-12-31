package com.kotlinplayground.classes

class Person(
    val name: String = "",
    val age: Int = 0
) {


    var email: String = ""
    var nameLength: Int = 0
    private var bankBalance: Double = 0.0

    init {
        println("Inside Init Block")
        nameLength = name.length
    }

    constructor(
        _email: String,
        _name: String = "",
        _age: Int = 0
    ) : this(_name, _age) {
        email = _email
    }

    fun action() {
        println("Person Walks")
    }

    private fun personalDetails() {
        println("Hanldes behavior tied to personal Details")
        bankBalance = 10000.0
    }

}

fun main() {

    val person = Person("Alex", 25) // new keyword is not needed
    person.action()
    println("Name : ${person.name} and the age is : ${person.age}")
    println("Length Of the name : ${person.nameLength}")

    val person1 = Person() // new keyword is not needed
    //person1.action()

    val person2 = Person(_email = "abc@gmail.com", "Alex", 25) // new keyword is not needed
    person1.action()
    println("Email is : ${person2.email}")

}