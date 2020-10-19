package com.qa.rest.tests;

import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	@BeforeTest
	public void Setup(){
		
		RestAssured.authentication=	RestAssured.preemptive().basic("ToolsQA", "TestPassword");
		
		RestAssured.baseURI="https://restapi.demoqa.com/authentication/CheckForAuthentication";

	}
	

}
