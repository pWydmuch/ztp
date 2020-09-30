package com.example.ztp0.daos.fileImpl;

import com.example.ztp0.daos.CourseDao;
import com.example.ztp0.model.Course;
import com.example.ztp0.model.Student;
import com.example.ztp0.util.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class CourseDaoFile implements CourseDao {

    String PATH = "C:\\Users\\IDEAPAD\\Desktop\\zamienniki f\\Patryk_Wydmuch_Etap_3_4\\kody-zrodlowe\\ztp0\\src\\main\\resources\\static\\courses.json";

    private final
    StudentDaoFile studentDaoFile;

    private
    JsonParser<Course> jsonParser;




    @Autowired
    public CourseDaoFile() {
        this.studentDaoFile = new StudentDaoFile();
        this.jsonParser = new JsonParser<>();

    }

    @Override
    public List<Student> addStudentToCourse(Long courseId,Long index){
        List<Course> courses = getCoursesFromJson();
        List<Student> students = getStudents(courseId);
        Student student= studentDaoFile.get(index).get();
        students.add(student);
        writeCoursesToJson(courses);
        return students;
    }

    @Override
    public List<Student> removeStudentFromCourse(Long courseId,Long index){
        List<Course> courses = getCoursesFromJson();
        List<Student> students = getStudents(courseId);
        Student student= getConcreteStudent(index,students);
        students.remove(student);
        writeCoursesToJson(courses);
        return students;
    }

    @Override
    public List<Student> getStudents(Long courseId){
        List<Student> students = getCoursesFromJson().stream().
                filter(s-> s.getId().equals(courseId)).
                findFirst().
                map(Course::getStudents).
                get();
        return students;
    }

    @Override
    public List<Student> getStudentsNotEnrolled(Long courseId) {
        List<Student> students = studentDaoFile.getAll().
                stream().
                filter(s->!isStudentEnrolled(s,courseId)).
                collect(Collectors.toList());
        return students;
    }


    private boolean isStudentEnrolled(Student student, Long courseId){
        Course course = getCoursesFromJson().stream()
                .filter(c->c.getId().equals(courseId))
                .findFirst()
                .get();

        return course.getStudents().contains(student);
    }



    @Override
    public Optional<Course> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Course> getAll() {
        return getCoursesFromJson();
    }

    @Override
    public void save(Course course) {
        List<Course> courses = getCoursesFromJson();
        courses.add(course);
        writeCoursesToJson(courses);
    }


    public void save(List<Course> courses) {

        writeCoursesToJson(courses);
    }

    @Override
    public void update(Long id, Course course) {

    }

    @Override
    public void delete(Long id) {
        List<Course> courses = getCoursesFromJson();
        Course course= courses.stream().
                filter(s-> s.getId().equals(id)).
                findFirst().
                get();

        courses.remove(course);
        writeCoursesToJson(courses);
    }

    private List<Course> getCoursesFromJson(){
        try {
            return jsonParser.retrieveData(Course.class, PATH);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void writeCoursesToJson(List<Course> courses){
        try {
            jsonParser.write(courses, PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Student getConcreteStudent(Long index, List<Student> students){
        return students.stream().
                filter(s-> s.getIndeks().equals(index)).
                findFirst().
                get();
    }
}
