package com.sachith.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class VirtualPowerPlantApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirtualPowerPlantApplication.class, args);
    }

}
