package com.kotlinplayground.interfaces

import com.kotlinplayground.classes.Course

interface CourseRepository {
    val isCoursePersisted: Boolean
        get() = false

    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("course : $course")
        return course.id
    }
}

interface Repository {

    fun getAll() : Any
}

 class SqlCourseRepository : CourseRepository, Repository {

    override var isCoursePersisted: Boolean = false
        get() {
            return true
        }


    override fun getById(id: Int): Course {
        return Course(
            id = id,
            "Kafka For Developers using Spring Boot",
            "Dilip Sundarraj"
        )
    }

    override fun save(course: Course): Int {
        println("course in SqlCourseRepository : $course")
        isCoursePersisted = true
        return course.id
    }

     override fun getAll(): Any {
         TODO("Not yet implemented")
     }

 }

class NoSqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(
            id = id,
            "Kafka For Developers using Spring Boot",
            "Dilip Sundarraj"
        )
    }

    override fun save(course: Course): Int {
        println("course in SqlCourseRepository : $course")
        return course.id
    }

}

interface A {
    fun doSomething() {
        println("Do Something in A")
    }
}

interface B {
    fun doSomething() {
        println("Do Something in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("Do something in AB")
    }

}

//INT9145453

fun main() {

    val course = Course(
        1,
        "Kafka For Developers using Spring Boot",
        "Dilip Sundarraj"
    )

    val sqlCourseRepository = SqlCourseRepository()
    sqlCourseRepository.save(course)

    val noSqlCourseRepository = NoSqlCourseRepository()
    noSqlCourseRepository.save(course)

    val ab = AB()
    ab.doSomething()
}