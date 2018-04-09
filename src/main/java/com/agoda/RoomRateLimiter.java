package com.agoda;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RoomRateLimiter extends RateLimiter {

	public RoomRateLimiter(@Value("${room.numberOfRequests}") int numberOfRequests,
			@Value("${room.timeInterval}") long timeInterval,
			@Value("${room.suspensionInterval}") long suspensionInterval) {
		super(numberOfRequests, timeInterval, suspensionInterval);
	}

}
