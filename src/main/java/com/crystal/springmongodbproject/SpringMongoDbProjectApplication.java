package com.crystal.springmongodbproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.crystal.springmongodbproject.repository")
public class SpringMongoDbProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoDbProjectApplication.class, args);
    }

}
