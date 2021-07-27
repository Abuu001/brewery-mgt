package com.lugonzo.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsccBreweryEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsccBreweryEurekaApplication.class, args);
	}

}
