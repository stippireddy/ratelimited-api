package com.agoda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({ "default.properties", "custom.properties" })
public class AgodaBackendDeveloperApplication {

	public static void main(String[] args) {
		final Logger logger = LoggerFactory.getLogger(AgodaBackendDeveloperApplication.class);
		ConfigurableApplicationContext context = SpringApplication.run(AgodaBackendDeveloperApplication.class, args);
		logger.info("Application started successfully");
		logger.debug("context.getBean(CityRateLimiter.class).getMaxRequests() : "
				+ context.getBean(CityRateLimiter.class).getMaxRequests());
		logger.debug("context.getBean(CityRateLimiter.class).getSuspensionInterval() : "
				+ context.getBean(CityRateLimiter.class).getSuspensionInterval());
		logger.debug("context.getBean(CityRateLimiter.class).getTimeInterval() : "
				+ context.getBean(CityRateLimiter.class).getTimeInterval());
		logger.debug("context.getBean(RoomRateLimiter.class).getMaxRequests() : "
				+ context.getBean(RoomRateLimiter.class).getMaxRequests());
		logger.debug("context.getBean(RoomRateLimiter.class).getSuspensionInterval() : "
				+ context.getBean(RoomRateLimiter.class).getSuspensionInterval());
		logger.debug("context.getBean(RoomRateLimiter.class).getTimeInterval() : "
				+ context.getBean(RoomRateLimiter.class).getTimeInterval());
	}
}
