package com.agoda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CityRateLimiterTest {
	@Test
	public void test() {
		CityRateLimiter cityRateLimiter = new CityRateLimiter(10, 1000, 500);
		assertEquals(10, cityRateLimiter.getMaxRequests());
		assertEquals(1000, cityRateLimiter.getTimeInterval());
		assertEquals(500, cityRateLimiter.getSuspensionInterval());
	}

}
