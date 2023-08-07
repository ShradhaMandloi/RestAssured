package SerializationAndDeserialization;

import org.testng.annotations.Test;

import Pojo.Data;
import Pojo.Get_ResponseBodyDS;
import Pojo.Support;
import io.restassured.RestAssured;


import static io.restassured.RestAssured.*;

import java.util.List;
public class Get_ListUserGDS {

	@Test
	public void getUser() {
		
		RestAssured.baseURI="https://reqres.in/";
	Get_ResponseBodyDS response = given()
		.when()
		.get("/api/users?page=2")
		.then()
		.extract()
		.response()
		.as(Get_ResponseBodyDS.class);
		
	Integer total = response.getTotal();
		System.out.println(total);
		Support support = response.getSupport();
		String text = support.getText();
		System.out.println(text);
		
		//WAP to fetch the third id value from the json response
		
		List<Data> alldata = response.getData();
		System.out.println(alldata.size());
		for(int i=0;i<=alldata.size()-1;i++)
		{
			Integer id2 = alldata.get(2).getId();
			System.out.println(id2);
			break;
		}
	
	}
}
