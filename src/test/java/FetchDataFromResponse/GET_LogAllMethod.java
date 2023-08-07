package FetchDataFromResponse;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_LogAllMethod {

	@Test
	public void getUser() {
		
		RestAssured.baseURI="https://reqres.in/";
		
		Response resp = given()
		
		.log().all()    // insteadof using asprettyString()  for data formating on console
		.when()
		.get("/api/users/2")
		.then()
		.log().all()
		.extract()
		.response();
		
		
		
	}
	
	
}
