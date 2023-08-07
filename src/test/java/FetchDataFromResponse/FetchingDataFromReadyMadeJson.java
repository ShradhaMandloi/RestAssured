package FetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class FetchingDataFromReadyMadeJson {

	@Test
	public void fetchData() {
		
		String json="{\r\n"
		+ "\"dashboard\": {\r\n"
		+ "\"purchaseAmount\": 910,\r\n"
		+ "\"website\": \"www.abc.com\"\r\n"
		+ "},\r\n"
		+ "\"courses\": [\r\n"
		+ "{\r\n"
		+ "\"title\": \"Selenium Python\",\r\n"
		+ "\"price\": 50,\r\n"
		+ "\"copies\": 6\r\n"
		+ "},\r\n"
		+ "{\r\n"
		+ "\"title\": \"Cypress\",\r\n"
		+ "\"price\": 40,\r\n"
		+ "\"copies\": 4\r\n"
		+ "},\r\n"
		+ "{\r\n"
		+ "\"title\": \"RPA\",\r\n"
		+ "\"price\": 45,\r\n"
		+ "\"copies\": 10\r\n"
		+ "}\r\n"
		+ "]\r\n"
		+ "}\r\n"
		+"";
		
		JsonPath js=new JsonPath(json);
		
//		String website = js.getString("dashboard.website");
//		System.out.println(website);
//		 
		// Print No of courses returned by API
		
//		int NoOfCourses = js.getInt("courses.size()");
//		
//		System.out.println(NoOfCourses);
//		
		// Print Purchase Amount
		
//		int totalamount = js.getInt("dashboard.purchaseAmount");
//		System.out.println(totalamount);
		
		//Print Title of the first course
		
//		String title0 = js.getString("courses[0].title");
//		
//		System.out.println(title0);
		
		// Print All course titles and their respective Prices
		
//		int NoOfCourses = js.getInt("courses.size()");
//		
//		for(int i=0; i<NoOfCourses; i++)
//		{
//			String title=js.getString("courses["+i+"].title");
//			int price = js.getInt("courses["+i+"].price");
//			
//			System.out.println(title+" : "+price);
//		}
//		
		//Print no of copies sold by RPA Course
		
//		int copies = js.getInt("courses[2].copies");
//		System.out.println(copies);

		//Verify if Sum of all Course prices matches with Purchase Amount
		int sum=0;
		int NoOfCourses = js.getInt("courses.size()");
		
		for(int i=0; i<NoOfCourses; i++)
		{
			int copies =js.getInt("courses["+i+"].copies");
			int price = js.getInt("courses["+i+"].price");
			
			int amount= copies *price;
			 sum=sum+amount;
			 System.out.println(sum);
		}
		
		int totalamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalamount);
		Assert.assertEquals(sum, totalamount);
		
		
	}
	
	
}
