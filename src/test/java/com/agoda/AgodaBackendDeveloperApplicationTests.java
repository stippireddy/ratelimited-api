package com.agoda;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AgodaBackendDeveloperApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AgodaBackendDeveloperApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveHotelsForBangkok() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(createURLWithPort("/city/bangkok"),
				HttpMethod.GET, entity, ResponseJson.class);
		ResponseJson responseString = response.getBody();
		assertEquals(200, responseString.getStatusCode());
	}

	@Test
	public void testRetrieveHotelsForBangkokUsesUpTheLimit() throws JSONException, InterruptedException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		String url = createURLWithPort("/city/bangkok");
		for (int i = 0; i < 100; i++) {
			restTemplate.exchange(url, HttpMethod.GET, entity, ResponseJson.class);
		}
		ResponseEntity<ResponseJson> response = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseJson.class);
		assertEquals(509, response.getBody().getStatusCode());
		Thread.sleep(10000);
		response = restTemplate.exchange(url, HttpMethod.GET, entity, ResponseJson.class);
		assertEquals(200, response.getBody().getStatusCode());
	}

	@Test
	public void testRetrieveHotelsForDeluxeRoom() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<ResponseJson> response = restTemplate.exchange(createURLWithPort("/room/deluxe"), HttpMethod.GET,
				entity, ResponseJson.class);
		ResponseJson responseString = response.getBody();
		assertEquals(200, responseString.getStatusCode());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
