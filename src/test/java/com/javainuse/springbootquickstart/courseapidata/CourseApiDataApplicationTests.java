package com.javainuse.springbootquickstart.courseapidata;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

 
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseApiDataApplicationTests {

	@Test
	public void contextLoads() {
	}

	/* REST Assured: Below we use the Given/When/Then structure that is borrowed from BDD (Behaviour Driven Development). 
	 * In Given section we declare things like content type or request body. 
	 * In When section we provide HTTP method and endpoint. 
	 * In Then section we declare response verification.
	 */

	/* REST Assured: Below we use the Given/When/Then structure that is borrowed from BDD (Behaviour Driven Development). 
	 * In Given section we declare things like content type or request body. 
	 * In When section we provide HTTP method and endpoint. 
	 * In Then section we declare response verification.
	 */
	
	//Add the Topics - POST http://localhost:9000/topics
	@Test
	public void postTopicsShouldResultInStatusok() throws JSONException {
		//Post first topic Spring
		JSONObject topic = new JSONObject()
				.put("id", "spring")
				.put("name", "SpringBoot")
				.put("description", "SpringBoot Description");		
		given()
			.body(topic.toString())
			.contentType("application/json")
		.when()
			.post("http://localhost:8080/topics")
		.then()
			.statusCode(200)
			.log().all();

		//Post second topic java
		topic = new JSONObject()
				.put("id", "java")
				.put("name", "JDK")
				.put("description", "JDK Description");		
		given()
			.body(topic.toString())
			.contentType("application/json")
		.when()
			.post("http://localhost:8080/topics")
		.then()
			.statusCode(200)
			.log().all();
		
		//Post third topic jee
		topic = new JSONObject()
				.put("id", "jee")
				.put("name", "JEE")
				.put("description", "JEE Description");
		
		given()
			.body(topic.toString())
			.contentType("application/json")
		.when()
			.post("http://localhost:8080/topics")
		.then()
			.statusCode(200)
			.log().all();		
	}
	
	
	//Validate status code for the Topics resource  - http://localhost:9000/topics
	@Test
	public void validateCourses() {
		given().queryParam("type", "json")
		.when().get("http://localhost:8080/topics")
		.then().statusCode(200).log().all();		
	}
	
	//Validate Response of the Topics resource  - http://localhost:9000/topics
	@Test
	public void validateCourses2() {
		ValidatableResponse response = given().queryParam("type", "json")
		.when().get("http://localhost:8080/topics")
		.then();	
	
		System.out.println("Response is :" + response.extract().body().asString());
	}	
}
