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

public class EmployeeDelete {

	
	
 @SuppressWarnings("unchecked")
 @Test(priority=0)	
 public void TokenGeneration(){
	 
	 RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/delete";
	 
	 RequestSpecification httprequest = RestAssured.given();
	 
	 JSONObject param = new JSONObject();
	 param.put("name", "Iftikhar");
	 param.put("salary", "100000");
	 param.put("age", "30");
	 
	 
	 httprequest.header("Content-Type","application/json");
		
	 httprequest.body(param.toJSONString());
	 
		
	 Response response =httprequest.request(Method.DELETE, "/4");
		String responseBody =	 response.getBody().asString();
	 
	 System.out.println("Response Body is" + responseBody);
	 
	 		
	 int statusCode = response.getStatusCode();
	 System.out.println("the status code is: "+ statusCode);
			
	 Assert.assertEquals(statusCode, 200);

	 
}

}