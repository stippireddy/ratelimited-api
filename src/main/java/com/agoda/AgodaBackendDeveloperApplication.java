package com.agoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "default.properties", "custom.properties" })
public class AgodaBackendDeveloperApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AgodaBackendDeveloperApplication.class, args);
		System.out.println("context.getBean(CityRateLimiter.class).getMaxRequests() : "
				+ context.getBean(CityRateLimiter.class).getMaxRequests());
		System.out.println("context.getBean(CityRateLimiter.class).getSuspensionInterval() : "
				+ context.getBean(CityRateLimiter.class).getSuspensionInterval());
		System.out.println("context.getBean(CityRateLimiter.class).getTimeInterval() : "
				+ context.getBean(CityRateLimiter.class).getTimeInterval());
		System.out.println("context.getBean(RoomRateLimiter.class).getMaxRequests() : "
				+ context.getBean(RoomRateLimiter.class).getMaxRequests());
		System.out.println("context.getBean(RoomRateLimiter.class).getSuspensionInterval() : "
				+ context.getBean(RoomRateLimiter.class).getSuspensionInterval());
		System.out.println("context.getBean(RoomRateLimiter.class).getTimeInterval() : "
				+ context.getBean(RoomRateLimiter.class).getTimeInterval());
	}
}
