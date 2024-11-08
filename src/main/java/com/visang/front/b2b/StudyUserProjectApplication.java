package com.visang.front.b2b;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.visang.front.b2b.user.mapper")
public class StudyUserProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyUserProjectApplication.class, args);
    }

}
