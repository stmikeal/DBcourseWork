package com.example.dbcoursework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DBcourseWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBcourseWorkApplication.class, args);
    }

}
