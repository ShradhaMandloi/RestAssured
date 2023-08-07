package Basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class POST_CreatingUser {

	@Test
	public void createUser(){
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		 Response response=given()
		.body("{\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"username\": \"testuser4\",\r\n"
				+ "    \"firstName\": \"shubh\",\r\n"
				+ "    \"lastName\": \"dashore\",\r\n"
				+ "    \"email\": \"shubh@gmail.com\",\r\n"
				+ "    \"password\": \"sd123\",\r\n"
				+ "    \"phone\": \"8521479632\",\r\n"
				+ "    \"userStatus\": 0\r\n"
				+ "  }")
	
		.header("Content-Type", "application/json")
		.when()
		.post("/user/createWithList")
		.then()
		.extract()
		.response();
		 
		 String strResp=response.asPrettyString();
		 System.out.println(strResp);	
		
	}
	
	@Test
	
	public void getUserDetails() {
		
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response resp=given()
		.when()
		.get("/user/createWithList/testuser4")
		.then()
		.extract()
		.response();
		
		String strResp1=resp.asPrettyString();
		System.out.println(strResp1);
			
	}
	
}
