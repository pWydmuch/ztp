package com.example.ztp0.daos.jdbcImpl;

import com.example.ztp0.daos.CourseDao;
import com.example.ztp0.model.Course;
import com.example.ztp0.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

//@Component
//@Primary
public class CourseDaoJdbc implements CourseDao {

    private final JdbcTemplate jdbcTemplate;


    private StudentDaoJdbc studentDaoJdbc;

    private Map<Long,List<Long>> courStud = new HashMap<>();


//    @Autowired

    public CourseDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentDaoJdbc = new StudentDaoJdbc(jdbcTemplate);
    }

    @Override
    public List<Student> getStudents(Long courseId) {
        String sqlQuery = "SELECT indeks, name, surname " +
                "FROM students s JOIN courses_students cs ON s.indeks = cs.students_indeks " +
                "WHERE cs.course_id = ?";

        return jdbcTemplate.query(sqlQuery,StudentDaoJdbc::mapRowToStudent, courseId);
    }

    @Override
    public List<Student> addStudentToCourse(Long courseId, Long index) {
        String sqlQuery = "INSERT INTO courses_students(course_id, students_indeks) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(sqlQuery, courseId,index);
        return getStudents(courseId);
    }

    @Override
    public List<Student> getStudentsNotEnrolled(Long courseId) {
        String sqlQuery = "SELECT indeks, name, surname " +
                "FROM students s LEFT JOIN courses_students cs ON s.indeks = cs.students_indeks " +
                "WHERE cs.course_id != ? OR cs.course_id IS NULL ";

        return jdbcTemplate.query(sqlQuery,StudentDaoJdbc::mapRowToStudent, courseId);
    }

    @Override
    public List<Student> removeStudentFromCourse(Long courseId, Long index) {
        String sqlQuery = "DELETE FROM courses_students WHERE students_indeks = ? AND course_id = ?";
        jdbcTemplate.update(sqlQuery, index,courseId);
        return getStudents(courseId);
    }

    @Override
    public Optional<Course> get(Long id) {
        String sqlQuery = "SELECT * FROM courses WHERE id = ?";
        return Optional.of(
                jdbcTemplate.queryForObject(sqlQuery, CourseDaoJdbc::mapRowToCourse, id)
        );
    }

    @Override
    public List<Course> getAll() {
        String sqlQuery = "SELECT * FROM courses";
        return jdbcTemplate.query(sqlQuery,CourseDaoJdbc::mapRowToCourse);
    }

    private  static Course mapRowToCourse(ResultSet resultSet, int rowNum) throws SQLException {
        Course course = new Course();
        course.setId(resultSet.getLong("id"));
        course.setName(resultSet.getString("name"));
        course.setCourseCode(resultSet.getString("course_code"));
        return course;

    }

    private Student  mapRowToCourseStudents(ResultSet resultSet, int rowNum) throws SQLException {
        Long coursId = resultSet.getLong("course_id");
        Long studsId = resultSet.getLong("students_indeks");
        if(courStud.containsKey(coursId)) {
            courStud.get(coursId).add(studsId);
        }
        else {
            List<Long> studs = new ArrayList<>();
            studs.add(studsId);
            courStud.put(coursId,studs);
        }
        return null;
    }

    public List<Course> getCourseWithStudents(){
        List<Course> allCourses = getAll();
        String sqlQuery = "SELECT * " +
                "FROM courses_students";
        jdbcTemplate.query(sqlQuery, this::mapRowToCourseStudents);
        List<Student> students= studentDaoJdbc.getAll();
        System.out.println(students);
        for(Long ind : courStud.keySet()){
            Course course = allCourses.stream().filter(c->c.getId().equals(ind)).findFirst().get();
//            System.out.println(students.stream().filter(s->s.get));
            List<Long> indekses = courStud.get(ind);
              indekses.forEach(index -> {
                  System.out.println(index);
                  Student student = students.stream()
                          .filter(s->s.getIndeks().equals(index))
                          .findFirst().get();
                  System.out.println(student);
                  course.setStudents(new ArrayList<>());
                  course.getStudents()
                      .add(student);

              });
//              indekses.forEach(index -> System.out.println(studentDaoJdbc.get(index).get()));
//            courses.add(course);
        }
//        System.out.println();
        courStud.clear();
        return allCourses;
    }

    @Override
    public void save(Course course) {
        String sqlQuery = "INSERT INTO courses(id, name, course_code) " +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(sqlQuery, course.getId(),
                course.getName(),
                course.getCourseCode());
    }

    @Override
    public void update(Long id, Course course) {

    }

    @Override
    public void delete(Long id) {
        String sqlQuery = "DELETE FROM courses WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}
