package com.manga.bdgest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.manga.bdgest.controller"})
public class BdGestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BdGestApplication.class, args);
    }

}
