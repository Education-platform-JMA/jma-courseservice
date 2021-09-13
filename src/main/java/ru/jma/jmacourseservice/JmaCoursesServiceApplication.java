package ru.jma.jmacourseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JmaCoursesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmaCoursesServiceApplication.class, args);
    }

}
