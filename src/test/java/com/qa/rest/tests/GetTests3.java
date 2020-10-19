package com.qa.rest.tests;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTests3 {
	public static RequestSpecification httpRequest;
	public static JSONObject json;
	public static Response response;
	public static int code;
	public static String data;
	String AccessToken;
	@Test
	public void getWeatherDetailsWithCorrectCityNameTest(){
		
		
		httpRequest=RestAssured.given();
		httpRequest.header("Content-Type","application/json");    
		json=new JSONObject();
		json.put("Asi","30232");
		json.put("Username", "fa20");
		json.put("Password", "test1234");
			 
		httpRequest.body(json.toJSONString());
			 
			 
		response=httpRequest.post("https://productservice.uat-asicentral.com/api/v5/Login");
			 
		code=response.getStatusCode();
				
		System.out.println("Status Code is:"+code);
				
		Assert.assertEquals(code, 200);
			  
			  String data=response.asString();
			  String[] abc =data.split("\"");
			  AccessToken =  abc[3];
			  System.out.println(AccessToken);
			  System.out.println(abc[3]);
			  System.out.println("Data is:"+data);
			 
		
		
			 	
			 	   
			 	httpRequest.header("Accept","application/json");
			 	   
			 	  httpRequest.header("Content-Type","application/json");

			 	 httpRequest.header("AuthToken",AccessToken);	 
			 		 
			 	   
			 	 RestAssured.baseURI = "https://productservice.uat-asicentral.com/api/v5";
			 	 RequestSpecification httpRequest = RestAssured.given();
			 	 Response response = httpRequest.get("/videos");

			 	 
			 	 
			 	 
		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below
		Headers allHeaders = response.headers();

		// Iterate over all the Headers
		for(Header header : allHeaders)
		{

			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());

		}	
	}
	

}
