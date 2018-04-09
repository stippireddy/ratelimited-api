package com.agoda;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ServicesTest {
	private MockMvc mockMvc;
	private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new Services(null, null)).build();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
