package com.kotlinspring.entity

import javax.persistence.*


@Entity
@Table(name = "COURSES")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int?,
    /* val name: String,
     val category: String*/
    var name: String,
    var category: String,
    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "INSTRUCTOR_ID", nullable = false)
    val instructor: Instructor? = null
){

    override fun toString(): String {
        return "Course(id=$id, name='$name', category='$category', instructor=${instructor!!.id})"
    }
}