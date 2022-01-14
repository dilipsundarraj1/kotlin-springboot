package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.KAFKA
import com.kotlinplayground.dataset.courseList


fun exploreHashMap() {

    val nameAgeMutableMap = mutableMapOf("dilip" to 33, "scooby" to 4)

    nameAgeMutableMap
        .forEach { (k, v) ->
            println("key: $k , value : $v")
        }

    val value = nameAgeMutableMap.getOrElse("dilip1") { "abc" }
    println("HashMap value : $value")

    val result = nameAgeMutableMap.containsKey("abc")
    println("HashMap  result : $result")

    val filteredMap = nameAgeMutableMap.filterKeys { it.length > 5 }
        .map { it.key.uppercase() }
    println("HashMap  filteredMap : $filteredMap")

    val maxAge = nameAgeMutableMap
        //.maxByOrNull { // This returns the whole entry of the map
        .maxOfOrNull {  // This returns the value
            it.value
        }
    println("HashMap maxAge : $maxAge")


}

fun main() {

    val devPredicate = { course: Course -> course.category == CourseCategory.DEVELOPEMENT }
    val desPredicate = { course: Course -> course.category == CourseCategory.DESIGN }


    val list = listOf(listOf(1,2,3),listOf(4,5,6) )

    val mapResult = list.map {
        it.map {
            it.toDouble()
        }
    }
    println("mapResult : $mapResult")

    val flatmapResult = list.flatMap { outerList ->
        outerList.map {
            it.toDouble()
        }
    }
    println("flatmapResult : $flatmapResult")


    val courseList = courseList()
    val developmentCourses = exploreFilter(courseList, devPredicate)
    println("developmentCourses : $developmentCourses")

    /*  val topicsCoveredUsingMap = developmentCourses.map {
          it.topicsCovered
      }
      println("topicsCoveredUsingMap : $topicsCoveredUsingMap")

      val topicsCoveredUsingFlatMap = developmentCourses.flatMap {
          it.topicsCovered
      }
      println("topicsCoveredUsingFlatMap : $topicsCoveredUsingFlatMap")*/

    exploreMap(courseList, desPredicate)

    val kafkaCourses = exploreFlatMap(courseList, KAFKA)
    println("kafkaCourses : $kafkaCourses")

    exploreHashMap()
}
private fun collections_nullability() {
    val list: List<String>? = null /*?: listOf()*/

    list?.forEach {

    }
    val list1: List<String?> = listOf("alex", null, "adam")

    list1
        .forEach {
            println(it?.length)
        }
}
private fun exploreMap(
    courseList: MutableList<Course>,
    desPredicate: (Course) -> Boolean
) {
    val designCourses = courseList.filter {
        //devPredicate
        desPredicate.invoke(it)

    }.map {
        //it.name
        "${it.name} -  ${it.category}"
    }
    println("designCourses : $designCourses")
}

private fun exploreFilter(
    courseList: MutableList<Course>,
    devPredicate: (Course) -> Boolean
): List<Course> {
    val developmentCourses = courseList.filter {
        //devPredicate
        devPredicate.invoke(it)

    }
    println("developmentCourses : $developmentCourses")
    return developmentCourses
}

private fun exploreFlatMap(developmentCourses: List<Course>, topic: String): List<String> {
    val kafkaCourses = developmentCourses
        .flatMap { course ->
            val courseName = course.name
            course.topicsCovered.filter {
                it == topic
            }.map {
                courseName
            }
        }

    return kafkaCourses
}