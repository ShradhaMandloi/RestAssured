package FetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Assignment1ToFetchLastnameOfByron {
	boolean returns=  false;
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
	  		
	  		int NoOfData = jp.getInt("data.size()");
	  		
	  		//Assignment: WAP to print all the values of email addresses for all the elements of array
	  		
	  		for(int i=0; i<=NoOfData-1;i++) {
	  			
	  		String email=jp.getString("data["+i+"].email");
	  			System.out.println(email);
	  		}
	  		
	  		//Assignment: WAP to print the lastname of user whose firstname is Byron
	  		
	  		String lastname="";
	  		for(int i=0; i<=NoOfData-1;i++)
	  		{
	  		String first_name=jp.getString("data["+i+"].first_name");
	  			if(first_name.equals("Byron")) {
	  				
	  				 lastname=jp.getString("data["+i+"].last_name");
	  			}
	  		}
	  		System.out.println(lastname);  		
	  }
	
	
}
