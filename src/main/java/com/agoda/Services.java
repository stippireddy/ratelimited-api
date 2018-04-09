package com.agoda;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class Services {

	private final CityRateLimiter cityLimiter;
	private final RoomRateLimiter roomLimiter;
	private final Logger logger = LoggerFactory.getLogger(Services.class);

	@Autowired
	public Services(@Qualifier("cityRateLimiter") IRateLimiter cityLimiter,
			@Qualifier("roomRateLimiter") IRateLimiter roomLimiter) {
		this.cityLimiter = (CityRateLimiter) cityLimiter;
		this.roomLimiter = (RoomRateLimiter) roomLimiter;
	}

	@ResponseBody
	@RequestMapping(value = "/city/{city}", method = RequestMethod.GET)
	public ResponseJson getHotelsByCity(@PathVariable String city,
			@RequestParam(required = false, value = "orderBy") String orderBy) {
		logger.info("Request received at the /city endpoint at " + LocalDateTime.now());
		logger.debug("Request params : [City: " + city + " , orderBy: " + orderBy + "]");
		synchronized (CityRateLimiter.class) {
			long currentTime = System.currentTimeMillis();
			if (cityLimiter.getSuspensionEndTime() > -1 && cityLimiter.getSuspensionEndTime() >= currentTime) {
				return suspensionMessage(cityLimiter);
			}

			long windowStartTime = currentTime - cityLimiter.getTimeInterval();
			ArrayDeque<Long> requestQueue = cityLimiter.getRequestQueue();
			while (!requestQueue.isEmpty() && windowStartTime >= requestQueue.peekFirst()) {
				requestQueue.poll();
			}
			if (requestQueue.size() >= cityLimiter.getMaxRequests()) {
				cityLimiter.setSuspensionEndTime(currentTime + cityLimiter.getSuspensionInterval());
				return suspensionMessage(cityLimiter);
			}
			cityLimiter.setSuspensionEndTime(-1);
			requestQueue.add(currentTime);
		}
		List<Hotel> totalList = ServiceUtils.getHotelList();
		System.out.println("Param City : " + city);
		System.out.println("Param OrderBy : " + orderBy);
		List<Hotel> filteredByCity = totalList.stream().filter(a -> a.getCity().equalsIgnoreCase(city))
				.collect(Collectors.toList());
		ResponseJson json = new ResponseJson();
		sort(orderBy, filteredByCity);
		json.setResults(filteredByCity);
		json.setStatusCode(HttpStatus.OK.value());
		json.setMessage(HttpStatus.OK.name());
		return json;
	}

	@ResponseBody
	@RequestMapping(value = "/room/{room}", method = RequestMethod.GET)
	public ResponseJson getHotelsByRoom(@PathVariable String room,
			@RequestParam(required = false, value = "orderBy") String orderBy) {
		synchronized (RoomRateLimiter.class) {
			long currentTime = System.currentTimeMillis();
			if (roomLimiter.getSuspensionEndTime() > -1 && roomLimiter.getSuspensionEndTime() >= currentTime) {
				return suspensionMessage(roomLimiter);
			}
			long windowStartTime = currentTime - roomLimiter.getTimeInterval();
			ArrayDeque<Long> requestQueue = roomLimiter.getRequestQueue();
			while (!requestQueue.isEmpty() && windowStartTime >= requestQueue.peekFirst()) {
				requestQueue.poll();
			}
			if (requestQueue.size() >= roomLimiter.getMaxRequests()) {
				roomLimiter.setSuspensionEndTime(currentTime + roomLimiter.getSuspensionInterval());
				return suspensionMessage(roomLimiter);
			}
			roomLimiter.setSuspensionEndTime(-1);
			requestQueue.add(currentTime);
		}
		List<Hotel> totalList = ServiceUtils.getHotelList();
		System.out.println("Param Room : " + room);
		System.out.println("Param OrderBy : " + orderBy);
		List<Hotel> filteredByRoom = totalList.stream().filter(a -> a.getRoom().equalsIgnoreCase(room))
				.collect(Collectors.toList());
		ResponseJson json = new ResponseJson();
		sort(orderBy, filteredByRoom);
		json.setResults(filteredByRoom);
		json.setStatusCode(HttpStatus.OK.value());
		json.setMessage(HttpStatus.OK.name());
		return json;
	}

	private ResponseJson suspensionMessage(IRateLimiter limiter) {
		ResponseJson json = new ResponseJson();
		json.setStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
		json.setMessage("Sorry, the system can not service your request at this time. Api is suspended for the next "
				+ (limiter.getSuspensionEndTime() - System.currentTimeMillis()) / 1000 + " seconds");
		return json;
	}

	private void sort(String orderBy, List<Hotel> list) {
		if (orderBy != null && list != null) {
			if (orderBy.equalsIgnoreCase("asc")) {
				list.sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));
			}
			if (orderBy.equalsIgnoreCase("desc")) {
				list.sort((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
			}
		}
	}
}
