package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.exception.CourseNotFoundException
import com.kotlinspring.exception.InstructorNotValidException
import com.kotlinspring.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository,
val instructorService: InstructorService) {

    fun addCourse(courseDTO: CourseDTO): CourseDTO {

        val instructor = instructorService.findInstructorById(courseDTO.instructorId!!)
        if(!instructor.isPresent){
            throw InstructorNotValidException("Instructor Id is not Valid!")
        }

        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category, instructor.get())
        }

        courseRepository.save(courseEntity)

        return courseEntity.let {
            CourseDTO(it.id!!, it.name, it.category)
        }
    }

    fun retrieveAllCourses(courseName: String?): List<CourseDTO> {

        val courses = if (courseName != null) {
            courseRepository.findCoursesByName(courseName)
        } else {
            courseRepository.findAll()
        }

        return courses.map {
            CourseDTO(it.id, it.name, it.category)
        }

    }


    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO {

        val existingCourse = courseRepository.findById(courseId)

        return if (existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.category = courseDTO.category
                    it.name = courseDTO.name
                    courseRepository.save(it)
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No Course Found for the passed in Id $courseId")
        }

    }

    fun deleteCourse(courseId: Int) {
        val existingCourse = courseRepository.findById(courseId)
        if (existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    courseRepository.deleteById(courseId)
                }
        } else {
            throw CourseNotFoundException("No Course Found for the passed in Id $courseId")
        }


    }


}