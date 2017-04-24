package com.oa.app;



import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

//@RestController
//@EnableAutoConfiguration
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class})
public class Application {

    /*@RequestMapping("/")
    String home() {
        return "Hello World naveen!";
    }*/

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}