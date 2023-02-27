package com.example.routecalculatorsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class RouteCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RouteCalculatorApplication.class, args);
	}
}
