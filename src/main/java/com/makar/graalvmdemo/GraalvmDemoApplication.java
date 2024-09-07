package com.makar.graalvmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(value = GraalVmRuntimeHints.class)
public class GraalvmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraalvmDemoApplication.class, args);
        System.out.println("Application started2");
    }

}
