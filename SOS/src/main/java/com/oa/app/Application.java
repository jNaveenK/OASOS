package com.oa.app;



import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

//@RestController
//@EnableAutoConfiguration
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /*@RequestMapping("/")
    String home() {
        return "Hello World naveen!";
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}