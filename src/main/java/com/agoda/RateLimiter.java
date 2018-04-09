package com.agoda;

import java.util.ArrayDeque;

public abstract class RateLimiter implements IRateLimiter {

	private final int maxRequests;
	private final long timeInterval;
	private final long suspensionInterval;
	private final ArrayDeque<Long> requestQueue;
	private long suspensionEndTime;

	public RateLimiter(int numberOfRequests, long timeInterval, long suspensionInterval) {
		this.maxRequests = numberOfRequests;
		this.timeInterval = timeInterval;
		this.suspensionInterval = suspensionInterval;
		requestQueue = new ArrayDeque<>();
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#getMaxRequests()
	 */
	@Override
	public int getMaxRequests() {
		return maxRequests;
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#getTimeInterval()
	 */
	@Override
	public long getTimeInterval() {
		return timeInterval;
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#getSuspensionInterval()
	 */
	@Override
	public long getSuspensionInterval() {
		return suspensionInterval;
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#getRequestQueue()
	 */
	@Override
	public ArrayDeque<Long> getRequestQueue() {
		return requestQueue;
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#getSuspensionEndTime()
	 */
	@Override
	public long getSuspensionEndTime() {
		return suspensionEndTime;
	}

	/* (non-Javadoc)
	 * @see com.agoda.IRateLimiter#setSuspensionEndTime(long)
	 */
	@Override
	public void setSuspensionEndTime(long suspendedEndTime) {
		this.suspensionEndTime = suspendedEndTime;
	}

}
