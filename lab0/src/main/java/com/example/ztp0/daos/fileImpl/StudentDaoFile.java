package com.example.ztp0.daos.fileImpl;

import com.example.ztp0.daos.StudentDao;
import com.example.ztp0.model.Student;
import com.example.ztp0.util.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoFile implements StudentDao {

    String PATH = "C:\\Users\\IDEAPAD\\Desktop\\zamienniki f\\Patryk_Wydmuch_Etap_3_4\\kody-zrodlowe\\ztp0\\src\\main\\resources\\static\\students.json";

    private
    JsonParser<Student> jsonParser;



//    @Autowired
    public StudentDaoFile() {
        this.jsonParser = new JsonParser<>();

//        students = jsonParser.retrieveData("students", "/static/students.json", Student.class);

    }

    @Override
    public Optional<Student> get(Long index) {
        List<Student> students = getStudentsFromJson();
        return students.stream().
                filter(s -> s.getIndeks().equals(index)).
                findFirst();
    }

    private List<Student> getStudentsFromJson() {
        try {
            return jsonParser.retrieveData(Student.class, PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeStudentsToJson(List<Student> students) {
        try {
            jsonParser.write(students, PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> getAll() {
        return getStudentsFromJson();
    }

    @Override
    public void save(Student student) {
        List<Student> students = getStudentsFromJson();
        students.add(student);
        writeStudentsToJson(students);
    }

    public void save(List<Student> students) {
        writeStudentsToJson(students);
    }

    @Override
    public void update(Long index, Student newStudent) {
        List<Student> students = getStudentsFromJson();
        Student student = students.stream().
                filter(s -> s.getIndeks().equals(index)).
                findFirst().
                get();
        student.setIndeks(newStudent.getIndeks());
        student.setName(newStudent.getName());
        student.setSurname(newStudent.getSurname());
        writeStudentsToJson(students);
    }

    @Override
    public void delete(Long index) {
        List<Student> students = getStudentsFromJson();
        Student student = students.stream().
                filter(s -> s.getIndeks().equals(index)).
                findFirst().
                get();
        students.remove(student);
        writeStudentsToJson(students);
    }
}
