package com.kotlinplayground.nulls

data class Movie(
    val id: Int?,
    val name: String
)

fun printName(name: String) {
    println("Name is : $name")
}

fun printName1(name: String?) {
    println("Name is : $name")
}


fun main() {

    var nameNullable: String? = null
    println(nameNullable?.length) // ? is the safeCall Operator
    nameNullable = "Alex"
    nameNullable?.run {
        printName(nameNullable!!)
    }


    val length = nameNullable?.length ?: 0 // ?: is the elvis Operator
    println(length)

    nameNullable = "alex"
    val length1 = nameNullable.length.toLong()
    println("Length of the name is : $length1")

    val nameNonNull: String = "Dilip"
    //val nameNonNull = "Dilip"

    println(nameNonNull)
    printName1(nameNonNull)

    val movie = saveMovie(Movie(null, "Avengers"))
    println(movie.id!!)
}

fun saveMovie(movie: Movie): Movie =
    movie.copy(id = 1)
    //movie.copy(id = null)