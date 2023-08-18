package com.assignment.apiusingspringboot;

import com.assignment.apiusingspringboot.service.OrderService;
import com.assignment.apiusingspringboot.service.OrderServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiUsingSpringbootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiUsingSpringbootApplication.class, args);
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }
}
