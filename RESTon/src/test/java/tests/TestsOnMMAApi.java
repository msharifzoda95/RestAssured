package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


//Running API tests on our LOCAL MMA app 
public class TestsOnMMAApi {

	
//using the Get method to see all fighters (.log().all() shows the list of fighters) 	
	@Test
	public void get() {
		baseURI = "http://localhost:3000";
		
		given().
		get("/fighter").
		then().
		statusCode(200).log().all();
		
	}
	
	
//using the Post method to add a new fighter  	
//	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Jiri");
		request.put("lastName", "Prochazka");
		request.put("organizationId", "1");
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/fighter")
		.then()
		.statusCode(201);
		
	}
	
	
//using the put method to add a new fighter 	
	@Test
public void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Patricky");
		request.put("lastName", "Pitbull");
		request.put("organizationId", "2");
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/fighter/4")
		.then()
		.statusCode(200);
		
	}
	
	
//Patching/Updating the last name of a fighter 
	//@Test
public void patch() {
		
		JSONObject request = new JSONObject();
			
		request.put("lastName", "Pfyfer");
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("/fighter/4")
		.then()
		.statusCode(200);
		
	}

//deleting fighter by the fighter id
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		
		when()
		.delete("/fighter/4")
		.then()
		.statusCode(200);
		
	}


}
