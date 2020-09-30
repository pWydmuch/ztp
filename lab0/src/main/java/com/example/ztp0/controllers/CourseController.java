package com.example.ztp0.controllers;

import com.example.ztp0.daos.CourseDao;

import com.example.ztp0.daos.Sync;
import com.example.ztp0.daos.fileImpl.CourseDaoFile;
import com.example.ztp0.daos.fileImpl.StudentDaoFile;
import com.example.ztp0.daos.fileImpl.SyncFile;
import com.example.ztp0.daos.jdbcImpl.CourseDaoJdbc;
import com.example.ztp0.daos.jdbcImpl.StudentDaoJdbc;
import com.example.ztp0.daos.jdbcImpl.SyncJdbc;
import com.example.ztp0.model.Course;
import com.example.ztp0.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RestController
@Controller
@RequestMapping("courses")
public class CourseController {

    private final JdbcTemplate jdbcTemplate;

    private
    CourseDao courseDao;

    Sync synchronizer;

    @Autowired
    public CourseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
       courseDao = new CourseDaoJdbc(this.jdbcTemplate);
        synchronizer = new SyncFile(this.jdbcTemplate);
    }


//    @Autowired
//    public CourseController(CourseDao courseDao) {
//        this.courseDao = courseDao;
//    }


    @ResponseBody
    @GetMapping("sync")
    public void sync(){
        System.out.println("sundd");
    synchronizer.sync();

    }

    @ResponseBody
    @GetMapping("switch-to-file")
    public void switchFile(){
        courseDao= new CourseDaoFile();
        synchronizer = new SyncJdbc(jdbcTemplate);
    }
    @ResponseBody
    @GetMapping("switch-to-db")
    public void switchDb(){
        courseDao = new CourseDaoJdbc(jdbcTemplate);
        synchronizer = new SyncFile(jdbcTemplate);
    }

    @PostMapping("")
    public String addCourse(Course course, BindingResult result , Model model){
        courseDao.save(course);
        model.addAttribute("courses", courseDao.getAll());
        return "courses";
    }

    @PostMapping("/delete")
    public String removeCourse(Course course, BindingResult result ,Model model){
        courseDao.delete(course.getId());
        model.addAttribute("courses", courseDao.getAll());
        return "courses";
    }

    @GetMapping("")
    String getCourses(Model model, Course course){
        model.addAttribute("courses", courseDao.getAll());
        return "courses";
    }

    @GetMapping("{courseId}/students")
    public String getStudents(@PathVariable Long courseId,Student student ,Model model){
        List<Student> students = courseDao.getStudents(courseId);
        List<Student> studentsNotEnrolled = courseDao.getStudentsNotEnrolled(courseId);
        model.addAttribute("studentsNE", studentsNotEnrolled);
        model.addAttribute("students", students);

        model.addAttribute("courseId", courseId);
        return  "students-of-course";
    }

    @PostMapping("{courseId}/students/enroll")
    public String addStudent(@PathVariable Long courseId,Student student, Model model){
        List<Student> students = courseDao.addStudentToCourse(courseId,student.getIndeks());
        List<Student> studentsNotEnrolled = courseDao.getStudentsNotEnrolled(courseId);
        model.addAttribute("studentsNE", studentsNotEnrolled);
        model.addAttribute("students", students);
        model.addAttribute("courseId", courseId);
        return "students-of-course";
    }

    @PostMapping("{courseId}/students/remove")
    public String removeStudent(@PathVariable Long courseId,Student student, Model model){
        List<Student> students = courseDao.removeStudentFromCourse(courseId,student.getIndeks());
        List<Student> studentsNotEnrolled = courseDao.getStudentsNotEnrolled(courseId);
        model.addAttribute("studentsNE", studentsNotEnrolled);
        model.addAttribute("students", students);
        model.addAttribute("courseId", courseId);
        return "students-of-course";
    }
}
