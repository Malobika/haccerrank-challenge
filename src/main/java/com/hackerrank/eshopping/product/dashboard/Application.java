package com.hackerrank.eshopping.product.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories
@EntityScan
@ComponentScan
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
      
        SpringApplication.run(Application.class, args);
    }
}
