package com.example.ztp0.daos;

import com.example.ztp0.model.Course;
import com.example.ztp0.model.Student;

import java.util.List;


public interface CourseDao extends Dao<Course> {
//    List<Student> getStudents(Long courseId, List<Course> courses);
    List<Student> getStudents(Long courseId);
    List<Student> addStudentToCourse(Long courseId,Long index);
    List<Student> getStudentsNotEnrolled(Long courseId);
    List<Student> removeStudentFromCourse(Long courseId,Long index);
}
