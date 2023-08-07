package FetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingJsonPathMethod {

	@Test
	public void getUserDetails() {
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		Response resp = given()
		.when()
		.get("/user/testuser2")
		.then()
		.extract()
		.response();
		
		String stsresp=resp.asPrettyString();
		System.out.println(stsresp);
		
		
		JsonPath jp = resp.jsonPath();
		
		String uname = jp.getString("username");
		System.out.println(uname);
		
		long idvalue = jp.getLong("id");
		System.out.println(idvalue);
	}
	
	
}
