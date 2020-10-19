package com.qa.rest.tests;



import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.ParamConfig;
import io.restassured.http.Method;
import io.restassured.path.xml.mapping.XmlPathObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3 {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int code;
	public static String data;
	String AccessToken;
	

 @SuppressWarnings("unchecked")
@Test(priority=3)	
public void GetAllVideo(){
	 
	//1. define the base url
 
			//2. define the http request:
			 resp=	RestAssured.given().
					 auth().
					 oauth2("8599b096fc5d5e885cd2025952c83c07878631b5").
					 post("http://coop.apps.symfonycasts.com/api/758/chickens-feed");
			
			int statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			
			Assert.assertEquals(statusCode, 200);
}

}