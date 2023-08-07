package SerializationAndDeserialization;

import org.testng.annotations.Test;

import Pojo.RequestBody;
import Pojo.ResponseBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateUserRR {

	@Test
	public void createUser() {
		
		RequestBody requestbody= new RequestBody();
		requestbody.setId(0);
		requestbody.setUsername("TestUser");
		requestbody.setFirstName("Pooja");
		requestbody.setLastName("Gupta");
		requestbody.setEmail("pg123@gmail.com");
		requestbody.setPassword("test123");
		requestbody.setPhone("8523697411");
		requestbody.setUserStatus(0);
		
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		ResponseBody Resp=given()
							.body(requestbody)
							.header("Content-Type", "application/json")
							.when()
							.post("/user")
							.then()
							.log().all()
							.extract()
							.response()
							.as(ResponseBody.class);
		
		String message=	Resp.getMessage();
		System.out.println(message);
	}
}
