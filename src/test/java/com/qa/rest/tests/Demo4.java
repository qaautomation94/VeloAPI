package com.qa.rest.tests;



import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.ParamConfig;
import io.restassured.http.Method;
import io.restassured.path.xml.mapping.XmlPathObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4 {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int code;
	public static String data;
	String AccessToken;
	
	@BeforeSuite
	public void setUp() throws Exception {
	    RestAssured.port = 8080;
	}
	
 @SuppressWarnings("unchecked")
 @Test(priority=0)	
 public void TokenGeneration(){
	 
    request=RestAssured.given();
	request.header("Content-Type","application/json");    
	json=new JSONObject();
	json.put("Asi","30232");
    json.put("Username", "fa20");
    json.put("Password", "test1234");
	 
	request.body(json.toJSONString());
	 
	 
	 resp=request.post("https://productservice.uat-asicentral.com/api/v5/Login");
	 
	  code=resp.getStatusCode();
		
	  System.out.println("Status Code is:"+code);
		
	  Assert.assertEquals(code, 200);
	  
	  String data=resp.asString();
	  String[] abc =data.split("\"");
	  AccessToken =  abc[3];
	  System.out.println(AccessToken);
	  System.out.println(abc[3]);
	 	  System.out.println("Data is:"+data);
	 
	 
 }
 

@SuppressWarnings("unchecked")
@Test(priority=3)	
public void GetAllVideo(){
	  

	resp=RestAssured.given().header("Authorization", AccessToken).get("https://productservice.uat-asicentral.com/Product/api/v4/products/11159-551410197");
		
	   			int statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			
			Assert.assertEquals(statusCode, 200);


}

}