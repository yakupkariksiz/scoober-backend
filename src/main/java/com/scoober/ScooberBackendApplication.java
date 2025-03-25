package com.scoober;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScooberBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScooberBackendApplication.class, args);
	}

	@Bean
    public CommandLineRunner printBeans(ApplicationContext ctx) {
        return args -> {
            System.out.println("Registered beans:");
            Arrays.stream(ctx.getBeanDefinitionNames())
                  .filter(name -> name.contains("order") || name.contains("controller"))
                  .forEach(System.out::println);
        };
    }

}
