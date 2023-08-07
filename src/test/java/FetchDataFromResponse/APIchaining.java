package FetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class APIchaining {
	String message;	
	@Test
		public void createUser(){
			
			RestAssured.baseURI="https://petstore.swagger.io/v2";
			 Response response=given()
			.body(" { \"id\": 0,\r\n"
					+ "  \"username\": \"testuser2\",\r\n"
					+ "  \"firstName\": \"lokesh\",\r\n"
					+ "  \"lastName\": \"mandloi\",\r\n"
					+ "  \"email\": \"lm123@gmail.com\",\r\n"
					+ "  \"password\": \"testuser123\",\r\n"
					+ "  \"phone\": \"9824754588\",\r\n"
					+ "  \"userStatus\": 0\r\n"
					+ "}")
		
			.header("Content-Type", "application/json")
			.when()
			.post("/user")
			.then()
			.extract()
			.response();
			 
			 String strResp=response.asPrettyString();
			 System.out.println(strResp);	
			JsonPath js= response.jsonPath();
			 message=js.getString("message");
			
		}
	
			@Test
			
			public void getUserDetails()
			{
				RestAssured.baseURI = "https://petstore.swagger.io/v2";
				
			Response resp = given()
				
				.when()
				
				.get("/user/testuser2")
				
				.then()
				
				.extract()
				
				.response();
			
			String response = resp.asPrettyString();
			
			System.out.println(response);
			
			JsonPath jp = resp.jsonPath();
			
			String uname = jp.getString("username");
			
			System.out.println(uname);
			
//			long idvalue = jp.getLong("id");
//			
//			System.out.println(idvalue);
			
			String idvalue=jp.getString("id");
			
			System.out.println(idvalue);
			
			Assert.assertEquals(idvalue, message);
	
			}
	
}
