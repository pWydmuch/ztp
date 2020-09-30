package com.example.ztp0.controllers;

import com.example.ztp0.daos.StudentDao;
import com.example.ztp0.daos.fileImpl.StudentDaoFile;
import com.example.ztp0.daos.jdbcImpl.StudentDaoJdbc;
import com.example.ztp0.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final JdbcTemplate jdbcTemplate;

    private
    StudentDao studentDao;

    public StudentController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        studentDao = new StudentDaoJdbc(jdbcTemplate);
    }

    @ResponseBody
    @GetMapping("switch-to-file")
    public void switchFile(){
        studentDao = new StudentDaoFile();
    }
    @ResponseBody
    @GetMapping("switch-to-db")
    public void switchDb(){
        studentDao = new StudentDaoJdbc(jdbcTemplate);
    }

    @GetMapping("")
    public String getStudents(Model model, Student student,BindingResult result) throws IOException {
        model.addAttribute("students", studentDao.getAll());
        return "students";
    }

    @GetMapping("/{index}")
    public Student getStudent(@PathVariable Long index){
        return studentDao.get(index).get();
    }

    @PostMapping("/{index}/update")
    public String updateStudent(@PathVariable Long index, Student student,BindingResult result ,Model model){
        studentDao.update(index,student);
        model.addAttribute("students", studentDao.getAll());
        return "students";
    }

    @PostMapping("")
    public String addStudent(Student student, BindingResult result , Model model){
        studentDao.save(student);
        model.addAttribute("students", studentDao.getAll());
        return "students";
    }

    @PostMapping("/delete")
    public String removeStudent(Student student, BindingResult result ,Model model){
        studentDao.delete(student.getIndeks());
        model.addAttribute("students", studentDao.getAll());
        return "students";
    }
    @GetMapping("/update/{index}")
    public String getStudentToUpdate(@PathVariable Long index,Model model){
        Student student = studentDao.get(index).get();
        model.addAttribute("student",student);
        return "student-update";
    }

    @ResponseBody
    @GetMapping("/test")
    public List<Student> getStudentToUpdate(){
        return studentDao.getAll();
    }

    @ResponseBody
    @GetMapping("/test/{id}")
    public Student getStudentToUpdate(@PathVariable Long id){
        return studentDao.get(id).get();
    }



}
