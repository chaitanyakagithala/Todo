package com.ToDo.Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.ToDo.Controller","com.ToDo.Service"})
@EntityScan("com.ToDo.Model")
@EnableJpaRepositories("com.ToDo.Repository")
@SpringBootApplication
public class TodoListApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

}
