package com.raditia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.raditia.persistence"})
//@EntityScan(basePackages = {"com.gdn.domain"})
//@ComponentScan(basePackages = {"com.gdn.persistence", "com.gdn.domain", "com.gdn.web"})

//Kalau modulnya banyak asalkan grupnya sama, dia bakal scan semua
@EnableJpaRepositories(basePackages = {"com.raditia"})
@EntityScan(basePackages = {"com.raditia"})
@ComponentScan(basePackages = {"com.raditia"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
