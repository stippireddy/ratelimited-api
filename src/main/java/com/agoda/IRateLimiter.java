package com.agoda;

import java.util.ArrayDeque;

public interface IRateLimiter {

	int getMaxRequests();

	long getTimeInterval();

	long getSuspensionInterval();

	ArrayDeque<Long> getRequestQueue();

	long getSuspensionEndTime();

	void setSuspensionEndTime(long suspendedEndTime);

}