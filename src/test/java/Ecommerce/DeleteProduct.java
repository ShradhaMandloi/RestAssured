package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class DeleteProduct extends BaseData{

	@Test
	public void deleteProduct() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		given()
		.header("Authorization", token_id)
		.pathParam("proid", productID)
		.when()
		.delete("/api/ecom/product/delete-product/{proid}")
		.then()
		.log().all()
		.extract()
		.response();
		
	}
}
