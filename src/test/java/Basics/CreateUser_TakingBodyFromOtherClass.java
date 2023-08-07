package Basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateUser_TakingBodyFromOtherClass {

	@Test
	public void CreateUser() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response Resp = given()
		.body(JsonBody.getbody())
		.header("Content-Type", "application/json")
		.when()
		.post("/user")
		.then()
		.extract()
		.response();
		String strResp=Resp.asPrettyString();
		System.out.println(strResp);
	}
	
}
