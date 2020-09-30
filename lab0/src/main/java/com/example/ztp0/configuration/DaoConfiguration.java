//package com.example.ztp0.configuration;
//
//import com.example.ztp0.daos.CourseDao;
//import com.example.ztp0.daos.fileImpl.CourseDaoFile;
//import com.example.ztp0.daos.jdbcImpl.CourseDaoJdbc;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//public class DaoConfiguration {
//
//    @Autowired
//    private final
//    JdbcTemplate jdbcTemplate;
//
//    public DaoConfiguration(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    @Bean
//    @Primary
//    public CourseDao getCourseDao(){
//        System.out.println("dupa");
//        return new CourseDaoJdbc(jdbcTemplate);
//    }
//
//}
