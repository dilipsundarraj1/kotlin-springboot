Greeting Controller:
====================
curl -i http://localhost:8080/v1/greetings/dilip

===================
Course Controller: |
===================

CREATE COURSE:
==============
curl -i \
-d '{"id":null, "name":"Build Restful APIs using Kotlin and SpringBoot", "category": "Development"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/v1/courses


curl -i \
-d '{"id":null, "name":"Build Reactive Microservices using Spring WebFlux/SpringBoot ", "category": "Development"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/v1/courses

GET COURSES:
==============
curl -i http://localhost:8080/v1/courses

UPDATE COURSE:
==============
curl -i \
-d '{"id":null, "name":"Build Restful APIs using Kotlin & SpringBoot2", "category": "Development"}' \
-H "Content-Type: application/json" \
-X PUT http://localhost:8080/v1/courses/1


DELETE COURSE:
==============
curl -i -X DELETE http://localhost:8080/v1/courses/1


=======================
Instructor Controller: |
=======================
CREATE INSTRUCTOR:
==================
curl -i \
-d '{"id":null, "name":"Dilip Sundarraj"}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/v1/instructors


CREATE COURSE WITH INSTRUCTOR:
==================
curl -i \
-d '{"id":null, "name":"Build Restful APIs using Kotlin and SpringBoot", "category": "Development", "instructorId": 1}' \
-H "Content-Type: application/json" \
-X POST http://localhost:8080/v1/courses
