package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAndPost {
	public static Response response;
	public static String jsonAsString;
//	@Test 
//	public void testGet() {
//		
//		baseURI = "https://reqres.in/api";
//		
//		given().
//			get("/users?page=2").
//		then().
//			statusCode(200).
//			body("data[4].first_name", equalTo("George")).
//			body("data.first_name", hasItems("George", "Rachel"));
//		
//	}

	
	@Test 
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		response = when().
			get("/users?page=2").
		then().extract().response();
		response.body().prettyPrint();
		jsonAsString = response.asString();
	    String firstName = response.path("data[4].first_name");
	    Assert.assertEquals(firstName, "George");

	}
		
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
				
//		map.put("name", "Johnny");
//		map.put("job", "Doctor");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Johnny");
		request.put("job", "Doctor");
		System.out.println(request.toJSONString());
		
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("content_type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
	}
}
