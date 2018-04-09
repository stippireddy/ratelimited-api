package com.agoda;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CityRateLimiter extends RateLimiter {

	public CityRateLimiter(@Value("${city.numberOfRequests}") int numberOfRequests,
			@Value("${city.timeInterval}") long timeInterval,
			@Value("${city.suspensionInterval}") long suspensionInterval) {
		super(numberOfRequests, timeInterval, suspensionInterval);
	}

}
