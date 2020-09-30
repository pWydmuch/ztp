package com.example.ztp0.daos.jdbcImpl;

import com.example.ztp0.daos.Sync;
import com.example.ztp0.daos.fileImpl.CourseDaoFile;
import com.example.ztp0.daos.fileImpl.StudentDaoFile;
import com.example.ztp0.model.Course;
import com.example.ztp0.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SyncJdbc implements Sync {

    private final JdbcTemplate jdbcTemplate;

    CourseDaoJdbc courseDaoJdbc;
    CourseDaoFile courseDaoFile;

    StudentDaoJdbc studentDaoJdbc;
    StudentDaoFile studentDaoFile ;

    @Autowired
    public SyncJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        courseDaoJdbc = new CourseDaoJdbc(jdbcTemplate);
        courseDaoFile = new CourseDaoFile();
        studentDaoJdbc = new StudentDaoJdbc(jdbcTemplate);
        studentDaoFile = new StudentDaoFile();
    }

    @Override
    public void sync(){
        List<Course> courses = courseDaoJdbc.getCourseWithStudents();
        courseDaoFile.save(courses);
        List<Student> studentList = studentDaoJdbc.getAll();
        studentDaoFile.save(studentList);
        System.out.println(studentDaoJdbc.get(121122l).get());
    }
}
