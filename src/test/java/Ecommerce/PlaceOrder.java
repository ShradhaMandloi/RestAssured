package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class PlaceOrder extends BaseData {

	@Test
	public void placeOrder() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given()
		.header("Authorization", token_id)
		.header("Content-Type", "application/json")
//		.body("{\r\n"
//				+ "    \"orders\": {\r\n"
//				+ "    \"country\": \"India\",\r\n"
//				+ "    \"productOrderedId\": \""+productID+"\"\r\n"
//				+ "    }\r\n"
//				+ "}")
		
		.body("{\r\n"
				+ "  \"orders\": {\r\n"
				+ "    \"country\": \"India\",\r\n"
				+ "    \"productOrderedId\": \""+productID+"\" \r\n"
				+ "  }\r\n"
				+ "}")
		.when()
		.post("/api/ecom/order/create-order\"")
		.then()
		.log().all()
		.extract()
		.response();
		
	}
	
}
