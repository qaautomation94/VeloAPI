package com.qa.rest.tests;



import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.config.ParamConfig;
import io.restassured.http.Method;
import io.restassured.path.xml.mapping.XmlPathObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AuthenticationTest {

	
	@BeforeSuite
	public void setUp() throws Exception {
	    RestAssured.port = 8080;
	}
	
 @SuppressWarnings("unchecked")
 @Test(priority=0)	
 public void TokenGeneration(){
	 
	 RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";
	 
	 PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
	 authscheme.setUserName("ToolsQA");
	 authscheme.setPassword("TestPassword");
	 
	 RestAssured.authentication=authscheme;
	 
	 RequestSpecification httprequest = RestAssured.given();
	 Response response =httprequest.request(Method.GET, "/");
		String responseBody =	 response.getBody().asString();
	 
	 System.out.println("Response Body is" + responseBody);
	 
	 		
	 int statusCode = response.getStatusCode();
	 System.out.println("the status code is: "+ statusCode);
			
	 Assert.assertEquals(statusCode, 200);


}

}