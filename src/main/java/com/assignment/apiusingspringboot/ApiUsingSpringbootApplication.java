package com.assignment.apiusingspringboot;

import lombok.extern.slf4j.Slf4j;
import org.owasp.encoder.Encode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ApiUsingSpringbootApplication {
    public static void main(String[] args) {
        log.info(Encode.forJava("starting springboot application..."));
        SpringApplication.run(ApiUsingSpringbootApplication.class, args);
    }
}
