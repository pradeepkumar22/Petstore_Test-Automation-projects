package PetstoreAPI_PostiveFlow;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;



public class PetstoreAPI {
	
	// Add proxy for the execution and unblock the comments
	//public PetstoreAPI() {
		//RestAssured.proxy("Your Proxy", Your Port);
	//}

	// Adding new pet and validating the status code
	@Test(priority=1)
	public void addNewPet()
	{	
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		String jsonbody="{\"id\": 103,\"category\": {\"id\": 0,\"name\": \"Pet Animal\"},\"name\": \"CAT\",\"photoUrls\": [\"https://pixabay.com/images/search/cat\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"Available\"}";
		 
		request.body(jsonbody.toString());
		Response response = request.post("http://petstore.swagger.io/v2/pet");
		ResponseBody<?> body= response.getBody();
		//System.out.println("req is .." +jsonbody);
		System.out.println("AddNewPet_Response  :  " +body.asString());
		 
		int statusCode = response.getStatusCode();
		System.out.println("AddNewPet_StatusCode :  " +statusCode);
		Assert.assertEquals(statusCode, 200);
	} 

	
	
	  // Retrieving added pet details using GET method. Also validating status code and status.
	  @Test(priority=2) 
	  public void getPet() 
	  {
	  
		  Response resp=RestAssured.get("http://petstore.swagger.io/v2/pet/103"); 
		  int code=resp.getStatusCode(); 
		  ResponseBody<?> body= resp.getBody();
		  System.out.println("getPet_AfterAdd_Response  :  " +body.asString());
		  System.out.println("getPet_AfterAdd_StatusCode :  " +code); 
		  Assert.assertEquals(code, 200);
		  //Assert.assertTrue(body.asString().contains("Available"));
		  JsonPath jsonPathEvaluator = resp.jsonPath();
		  String status = jsonPathEvaluator.get("status");
		  Assert.assertTrue(status.equalsIgnoreCase("Available"));
	  }
	 
	 // Updating pet details using PUT method. Validating the status code.
	  @Test(priority=3)
	  public void updatePet()
		{	
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type","application/json");
			String jsonbody="{\"id\": 103,\"category\": {\"id\": 0,\"name\": \"Pet Animal\"},\"name\": \"CAT\",\"photoUrls\": [\"https://pixabay.com/images/search/cat\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"Sold\"}";
			 
			request.body(jsonbody.toString());
			Response response = request.put("http://petstore.swagger.io/v2/pet");
			ResponseBody<?> body= response.getBody();
			//System.out.println("req is .." +jsonbody);
			System.out.println("updatePet_Response  :  " +body.asString());
			 
			int statusCode = response.getStatusCode();
			System.out.println("updatePet_StatusCode :  " +statusCode);
			Assert.assertEquals(statusCode, 200);
		} 
	  
	  // Retrieving updated pet details using GET method. Also validating status code and status.
	  @Test(priority=4) 
	  public void getPet_afterUpdate() {
	  
	  Response resp=RestAssured.get("http://petstore.swagger.io/v2/pet/103"); 
	  int code=resp.getStatusCode(); 
	  ResponseBody<?> body= resp.getBody();
	  System.out.println("getPet_AfterUpdate_Response  :  " +body.asString());
	  System.out.println("getPet_AfterUpdate_StatusCode :  " +code);
	  Assert.assertEquals(code, 200);
	  Assert.assertTrue(body.asString().contains("Sold"));
	  }
	  
	  // Deleting the pet details and validating the status code.
	  @Test(priority=5)
	  public void deletePet()
		{	
		  Response resp=RestAssured.delete("http://petstore.swagger.io/v2/pet/103"); 
		  int code=resp.getStatusCode(); 
		  ResponseBody<?> body= resp.getBody();
		  System.out.println("deletePet_Response  :  " +body.asString());
		  System.out.println("deletePet_StatusCode :  " +code);
		  Assert.assertEquals(code, 200);
		} 
	  
	  // Retrieving the pet information after deleting. Validating the proper error message.
	  @Test(priority=6) 
	  public void getPet_afterDelete() {
	  
	  Response resp=RestAssured.get("http://petstore.swagger.io/v2/pet/103"); 
	  int code=resp.getStatusCode(); 
	  ResponseBody<?> body= resp.getBody();
	  System.out.println("getPet_AfterDelete_Response  :  " +body.asString());
	  System.out.println("getPet_AfterDelete_StatusCode :  " +code);
	  Assert.assertEquals(code, 404);
	  Assert.assertTrue(body.asString().contains("Pet not found"));
	  }
}
