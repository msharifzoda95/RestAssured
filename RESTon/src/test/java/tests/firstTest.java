package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class firstTest {
	//This is a test to see if this comment gets posted
	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("Status code: "+response.getStatusCode());
		System.out.println("Time: "+response.getTime());
		System.out.println("body: "+ response.getBody().asString());
		System.out.println("Status Line: " + response.getStatusLine());
		System.out.println("Header: " + response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	} 
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().statusCode(200).
		body("data[1].first_name", equalTo("Lindsay")).
		log().all();
	}

}
