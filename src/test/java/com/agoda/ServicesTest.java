package com.agoda;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ServicesTest {
	private MockMvc mockMvc;
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.standaloneSetup(new Services(new CityRateLimiter(10, 5000, 1000), new RoomRateLimiter(10, 5000, 1000)))
				.build();
	}

	@Test
	public void test() throws Exception {
		this.mockMvc.perform(get("/room/deluxe")).andExpect(status().isOk());
		this.mockMvc.perform(get("/city/bangkok")).andExpect(status().isOk());
	}

}
