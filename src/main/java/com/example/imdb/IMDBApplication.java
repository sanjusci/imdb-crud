package com.example.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class IMDBApplication {

    @RequestMapping("/")
    String home() {
        return "Welcome to your first Spring boot Application!";
    }
    @GetMapping("/test")
    String index() {
        return "Hello world!";
    }

    public static void main(String[] args) {
        SpringApplication.run(IMDBApplication.class, args);

    }
}