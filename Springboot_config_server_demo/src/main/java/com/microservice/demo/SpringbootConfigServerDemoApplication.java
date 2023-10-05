package com.microservice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringbootConfigServerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootConfigServerDemoApplication.class, args);
	}

}
