package dev.leoferreira.testcontainers;

import org.springframework.boot.SpringApplication;

public class TestExampleUseOfTestContainersApplication {

	public static void main(String[] args) {
		SpringApplication.from(TestContainersExampleApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
