package com.kotlinspring.repository

import com.kotlinspring.CourseCatalogServiceApplication
import com.kotlinspring.util.courseEntityList
import com.kotlinspring.util.instructorEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.stream.Stream

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryIntgTest : PostgreSQLContainerInitializer{

    @Autowired
    lateinit var courseRepository: CourseRepository


    @Autowired
    lateinit var instructorRepository: InstructorRepository



    @BeforeEach
    fun setUp(){
        instructorRepository.deleteAll()
        courseRepository.deleteAll()

        val instructor = instructorEntity()
        instructorRepository.save(instructor)

        val courses = courseEntityList(instructor)
        courses.forEach {
            courseRepository.save(it)
        }

    }

    @Test
    fun findByNameContaining() {

        val courses = courseRepository.findByNameContaining("SpringBoot")

        println("courses  : $courses")
        assertEquals(2, courses.size)

    }

    @Test
    fun findCoursesByName() {

        val courses = courseRepository.findCoursesByName("SpringBoot")

        println("courses  : $courses")
        assertEquals(2, courses.size)

    }


    @ParameterizedTest
    @MethodSource("courseAndSize")
    fun findCoursesByName_approach2(name: String, expectedSize:  Int) {

        val courses = courseRepository.findCoursesByName(name)

        println("courses  : $courses")
        assertEquals(expectedSize, courses.size)

    }


    companion object {
        @JvmStatic
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(Arguments.arguments("SpringBoot", 2),
                Arguments.arguments("Wiremock", 1))

        }


    }
}

@Testcontainers
interface PostgreSQLContainerInitializer {
    companion object {
        @Container
        private val postgresDB: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:13.2")
            .withDatabaseName("testdb")
            .withUsername("postgres")
            .withPassword("secret")

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresDB::getJdbcUrl)
            registry.add("spring.datasource.username", postgresDB::getUsername)
            registry.add("spring.datasource.password", postgresDB::getPassword)
        }
    }
}
