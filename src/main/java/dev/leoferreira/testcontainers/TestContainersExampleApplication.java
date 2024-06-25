package dev.leoferreira.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
public class TestContainersExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestContainersExampleApplication.class, args);
    }

}
