package com.kotlinplayground;

import com.kotlinplayground.classes.Course;
import com.kotlinplayground.classes.CourseCategory;
import com.kotlinplayground.classes.CourseKt;

public class InvokeKoltinFromJava {

    public static void main(String[] args) {

        var course = new
                Course(1,
                "Reactive Programming in Modern Java using Project Reactor",
                "Dilip"
        , CourseCategory.DEVELOPEMENT
                );

        CourseKt.printName1("dilip");

        course.noOfCourses= 10;
    }
}

