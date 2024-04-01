package com.ait.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DoorDashServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoorDashServiceRegistryApplication.class, args);
	}

}
