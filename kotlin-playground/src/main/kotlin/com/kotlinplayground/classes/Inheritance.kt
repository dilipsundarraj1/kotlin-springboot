package com.kotlinplayground.classes


open class User(
    val name: String,
   open val age: Int = 0
) {
    open val isLoggedIn : Boolean = true
    open fun login() {
        println("Inside user login")
    }

   protected open fun logout(){
        println("Inside user logout")

    }
}

class Student(
    name: String,
   override val age: Int = 0
) : User(name, age) {

    override var isLoggedIn : Boolean = false

    companion object {
        const val noOfEnrolledCourses = 10

        fun country(): String {
            return "USA"
        }
    }

    override fun login() {
        super.login()
        println("Inside Student login")
        isLoggedIn = true
    }

    fun logOut() {
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
    Student.country()
    println("noOfEnrolledCourses:  ${Student.noOfEnrolledCourses}")
    Student.country()

    val user = User("Dilip")




    /*val instructor = Instructor("Dilip")
    instructor.login()*/
}
