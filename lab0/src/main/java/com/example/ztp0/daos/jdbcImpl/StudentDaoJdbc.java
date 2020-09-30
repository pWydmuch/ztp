package com.example.ztp0.daos.jdbcImpl;

import com.example.ztp0.daos.StudentDao;
import com.example.ztp0.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class StudentDaoJdbc implements StudentDao {


    private final JdbcTemplate jdbcTemplate;


//    @Autowired
    public StudentDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Student> get(Long indeks) {
        String sqlQuery = "SELECT * FROM students WHERE indeks = ?";
        return Optional.of(
                jdbcTemplate.queryForObject(sqlQuery, StudentDaoJdbc::mapRowToStudent, indeks)
        );
    }

    @Override
    public List<Student> getAll() {
        String sqlQuery = "SELECT * FROM students";
        if(jdbcTemplate == null){
            System.out.println("null");
        }
        else System.out.println("not null");
        return jdbcTemplate.query(sqlQuery,StudentDaoJdbc::mapRowToStudent);
    }

    static Student mapRowToStudent(ResultSet resultSet, int rowNum) throws SQLException {
        Student student = new Student();
        student.setIndeks(resultSet.getLong("indeks"));
        student.setName(resultSet.getString("name"));
        student.setSurname(resultSet.getString("surname"));
        return student;
    }

    @Override
    public void save(Student student) {
        String sqlQuery = "INSERT INTO students(name, surname, indeks) " +
                "VALUES (?, ?, ?)";

        jdbcTemplate.update(sqlQuery, student.getName(),
                student.getSurname(),
                student.getIndeks());
    }

    @Override
    public void update(Long id, Student student) {
        String sqlQuery = "UPDATE students SET " +
                "name = ?, surname = ?, indeks  = ? " +
                "where indeks = ?";

        jdbcTemplate.update(sqlQuery
                , student.getName()
                , student.getSurname()
                , student.getIndeks()
                , student.getIndeks());
    }

    @Override
    public void delete(Long indeks) {
        String sqlQuery = "DELETE FROM students WHERE indeks = ?";
        jdbcTemplate.update(sqlQuery, indeks);
    }
}
