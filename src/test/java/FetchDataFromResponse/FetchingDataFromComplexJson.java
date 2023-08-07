package FetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchingDataFromComplexJson {
   @Test
public void getUser() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp = given()
		
		.log().all()    // insteadof using asprettyString()  for data formating on console
		.when()
		.get("/api/users?page=2")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jp = resp.jsonPath();
		
		int total = jp.getInt("total");
		System.out.println(total);
		
		String text = jp.getString("support.text");
		
		System.out.println(text);
		
		String fname = jp.getString("data[0].first_name");
		System.out.println(fname);
		
		int totalelements = jp.getInt("data.size()");
		System.out.println(totalelements);
	
		//Assignment: WAP to print all the values of email addresses for all the elements of array
		
		String email0 = jp.getString("data[0].email");
		  
		  System.out.println(email0);
		  
	String email01 = jp.getString("data[1].email");
		  
		  System.out.println(email01);
		  
	String email02 = jp.getString("data[2].email");
		  
		  System.out.println(email02);
		  
	String email03 = jp.getString("data[3].email");
		  
		  System.out.println(email03);
		  
	String email04 = jp.getString("data[4].email");
		  
		  System.out.println(email04);
		  
	String email05 = jp.getString("data[5].email");
		  
		  System.out.println(email05);
		    
		
		
		
		
	}
	
	
	
}
