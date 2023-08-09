package Ecommerce;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
public class AddProduct extends BaseData{

	@Test
	public void addProducttoApp() {
		String path = System.getProperty("user.dir")+"\\src\\test\\resources\\Images\\PartyDress.PNG";
		File file= new File(path);
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response response = given()
				.header("Authorization", token_id)
				
				.param("productName", "Party wear Jeans")
				.param("productAddedBy", user_id)
				.param("productCategory", "fashion")
				.param("productSubCategory", "Trouser")
				.param("productPrice", "2000")
				.param("productDescription", "Levis Jeans")
				.param("productFor", "Women")
				.multiPart("productImage", file)
		
		.when()
		
		.post("/api/ecom/product/add-product")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jp = response.jsonPath();
		
		String productID=jp.getString("productId");
		System.out.println(productID);
		
		
	}
	
}
