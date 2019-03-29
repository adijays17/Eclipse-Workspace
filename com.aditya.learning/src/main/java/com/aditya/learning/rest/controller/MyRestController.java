package com.aditya.learning.rest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MyRestController {

    @RequestMapping("/")
    public String index() {
        return "Hi!! I am Aditya";
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyRestController.class, args);
    }

}