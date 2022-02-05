package com.kotlinplayground;

import com.kotlinplayground.classes.Authenticate;
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
        Course.Companion.printName2("abc");
        var courseName = Course.courseName;
        Course.printName2("abc");
        //CourseUtils.printName1("dilip");

        course.noOfCourses= 10;

        //Authenticate.INSTANCE.authenticate("abc", "password");
        Authenticate.authenticate("abc", "password");
    }
}

