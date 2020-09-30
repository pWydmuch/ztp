package com.example.ztp0.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseCode;
    private String name;

    @OneToMany
    private List<Student> students;

    public Course() {

    }

    public Course(Long id, String courseCode, String name, List<Student> students) {
        this.id = id;
        this.courseCode = courseCode;
        this.students = students;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
