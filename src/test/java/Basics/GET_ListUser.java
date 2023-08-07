package Basics;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class GET_ListUser {

	@Test
	public void getUsers() {
		
		RestAssured.baseURI="https://reqres.in/";
		
	Response resp =	given()
					.when()
					.get("/api/users/2")
					.then()
					.extract()
					.response();
	
	String StringResp=resp.asPrettyString();
	
	System.out.println(StringResp);
		
	int stsCode=resp.statusCode(); // to fetch status code
	
	System.out.println("status code: "+stsCode);
	
	Assert.assertEquals(stsCode, 200);
	
	long timeTaken=resp.getTime();
	
	System.out.println("Time Taken to fetch the data: "+timeTaken);
	}
}
