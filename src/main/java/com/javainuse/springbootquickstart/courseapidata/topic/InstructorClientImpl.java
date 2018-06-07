package com.javainuse.springbootquickstart.courseapidata.topic;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class InstructorClientImpl implements InstructorClient {
	
	/* (non-Javadoc)
	 * @see com.javainuse.springbootquickstart.courseapidata.course.InstructorClient#getInstructor(java.lang.String)
	 */
	@Override
	public Instructor getInstructor(String instructorId) {
		String baseUrl = "http://localhost:9080/instructors";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;		
		try {
			response=restTemplate.exchange(baseUrl, HttpMethod.GET,getHeaders(),String.class);
		} catch (Exception ex)
		{
			System.out.println(ex);
		}		
		return (Instructor) response;
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
