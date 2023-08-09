package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class LoginApp extends BaseData {

	@Test
	public void createUser() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response response = given()
//		.body("{\r\n"
//				+ "    \"userEmail\": \"test12345@abc.com\",\r\n"
//				+ "    \"userPassword\": \"Test@123\"\r\n"
//				+ " }")
		
				.body("{\r\n"
				+ "  \"userEmail\": \"test12345@abc.com\",\r\n"
				+ "  \"userPassword\": \"Test@123\"\r\n"
				+ "}")
		.header("Content-Type", "application/json")
		.when()
		.post("/api/ecom/auth/login")
		.then()
		.extract()
		.response();
		
		String stsres=response.asPrettyString();
		
		System.out.println(stsres);
		
		JsonPath jp = response.jsonPath();
		
		String userID=jp.getString("userId");
		user_id=userID;
		System.out.println("userid is: "+userID);
		
		
		String tokenID=jp.getString("token");
		token_id=tokenID;
		System.out.println("token is: "+tokenID);
		
	}
	
	
}
