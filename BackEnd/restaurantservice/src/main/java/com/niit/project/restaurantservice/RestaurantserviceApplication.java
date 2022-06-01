package com.niit.project.restaurantservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantserviceApplication.class, args);
	}

}
