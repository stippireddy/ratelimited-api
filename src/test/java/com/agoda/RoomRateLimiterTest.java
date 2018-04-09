package com.agoda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoomRateLimiterTest {

	@Test
	public void test() {
		RoomRateLimiter roomRateLimiter = new RoomRateLimiter(10, 1000, 500);
		assertEquals(10, roomRateLimiter.getMaxRequests());
		assertEquals(1000, roomRateLimiter.getTimeInterval());
		assertEquals(500, roomRateLimiter.getSuspensionInterval());
	}

}
