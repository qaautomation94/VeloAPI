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

public class Demo {
	@Test
	public void getWeatherDetailsWithCorrectCityNameTest(){
		
	int code=	RestAssured.given()
		.auth().preemptive()
		.basic("ToolsQA", "TestPassword")
		.when()
		.get("https://restapi.demoqa.com/authentication/CheckForAuthentication")
		.getStatusCode();
		
		
		System.out.println("Response code from the server is "+ code);

	}
	

}
