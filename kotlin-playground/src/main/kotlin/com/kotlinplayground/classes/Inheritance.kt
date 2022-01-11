package com.kotlinplayground.classes


open class User(
    val name: String,
   val age: Int = 0
) {
    open val isLoggedIn : Boolean = true
    open fun login() {
        println("Inside user login")
    }

    private fun secret(){

    }

   protected open fun logout(){
        println("Inside user logout")

    }
}

class Student(
    name: String,
    age: Int = 0
) : User(name, age) {

    override var isLoggedIn : Boolean = false

    companion object {
        const val noOfEnrolledCourses = 10

        fun country(): String {
            return "USA"
        }
    }

    fun secret(){

    }

    override fun login() {
        super.login()
        println("Inside Student login")
        isLoggedIn = true
    }

    override fun logout() {
        super.logout()
        println("Inside Student logout")
        isLoggedIn = false
    }
}

class Instructor(name: String) : User(name) {
    override fun login() {
        println("Inside Instructor login")
    }
}

fun main() {

    val student = Student("Dilip")
    student.login()

    val instructor = Instructor("Dilip")
    instructor.login()

    Student.country()
    println("noOfEnrolledCourses:  ${Student.noOfEnrolledCourses}")
    Student.country()

    val user = User("Dilip")

    //user.

    /*val instructor = Instructor("Dilip")
    instructor.login()*/
}
