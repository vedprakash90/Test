package com.sapients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientApplication.class, args);
	}
}
