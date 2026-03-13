package com.lpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiveRegisteryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiveRegisteryApplication.class, args);
	}

}
