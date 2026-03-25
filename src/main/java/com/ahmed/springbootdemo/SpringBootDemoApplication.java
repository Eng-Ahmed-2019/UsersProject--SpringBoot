package com.ahmed.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);

        /*
        List<String> names = List.of("Ahmed", "Ali", "Mona");
        for (String name : names) {
            System.out.println(name);
        }
         */
    }
}