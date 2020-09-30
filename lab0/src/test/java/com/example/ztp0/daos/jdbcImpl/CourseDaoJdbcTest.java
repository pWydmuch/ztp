package com.example.ztp0.daos.jdbcImpl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@Component
@RunWith(SpringRunner.class)
class CourseDaoJdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void getStudents() {
        System.out.println("dfsf");
        System.out.println(jdbcTemplate.getDataSource());
    }
}