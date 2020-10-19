package com.qa.rest.tests;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTests2 {
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
			 
			 
		    response=httpRequest.post("https://productservice.uat-asicentral.com/api/v4/Login");
			 
			  code=response.getStatusCode();
				
			  System.out.println("Status Code is:"+code);
				
			  Assert.assertEquals(code, 200);
			  
			  String data=response.asString();
			  String[] abc =data.split("\"");
			  AccessToken =  abc[3];
			  System.out.println(AccessToken);
			  System.out.println(abc[3]);
			 	  System.out.println("Data is:"+data);
			 
		
		
			 	 httpRequest=RestAssured.given();
			 	
			 	   
			 	httpRequest.header("Accept","application/json");
			 	   
			 	  httpRequest.header("Content-Type","application/json");

			 	 httpRequest.header("AuthToken",AccessToken);	 
			 		 
			 	   
		
		
		
		
		RestAssured.baseURI = "https://uat-productservice.asicentral.com/api/v5";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/videos");

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type value: " + contentType);

		// Reader header of a give name. In this line we will get
		// Header named Server
		String serverType =  response.header("Server");
		System.out.println("Server value: " + serverType);

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Content-Encoding: " + acceptLanguage);
	
	}
	

}
