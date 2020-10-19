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

public class velospecialVideo {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int code;
	public static String data;
	String AccessToken;
	
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
	 
	 
	 resp=request.post("https://productservice.uat-asicentral.com/api/v4/Login");
	 
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
 
/*

@SuppressWarnings("unchecked")
@Test(priority=1)	
public void PostVideo(){
	 
   request=RestAssured.given();
	
   
   request.header("Accept","application/json");
   
   request.header("Content-Type","application/json");

   request.header("AuthToken",AccessToken);	 
	 
   
   JSONObject json = new JSONObject();
	
	JSONArray array = new JSONArray();
	JSONObject item = new JSONObject();
	
	String VidName="Auto Video";
	Random ran = new Random();
	int n = ran.nextInt(500000);
	String VidName1=VidName+n;
			
	item.put("Name", VidName1);
	item.put("Type", "SUPPLIER");
	item.put("URL", "https://www.youtube.com/watch?v=9zShCGT3R0A");
	item.put("Description", "Test Videos and dgfg8u98 71189");

	array.add(item);
	json.put("", array);
	request.body(array.toJSONString());

	resp=request.post("https://productservice.uat-asicentral.com/api/v5/videos/");
    
	code=resp.getStatusCode();
		
	System.out.println("Status Code is:"+code);
		
	  //Assert.assertEquals(code, 200);
	 
      String data=resp.asString();
	  
	  System.out.println("Data is:"+data);
	 
}

@SuppressWarnings("unchecked")
@Test(priority=2)	
public void VeloSpecials(){
	 
   request=RestAssured.given();
	
   
   request.header("Accept","application/json");
   
   request.header("Content-Type","application/json");

   request.header("AuthToken",AccessToken);	 
	 
   
   JSONObject json = new JSONObject();
	
	JSONArray array = new JSONArray();
	JSONObject item = new JSONObject();
   
  // item.put("Id","6593");
   item.put("TypeCode","RUSF");
 
   String SpecName="Auto Specials";
	Random ran = new Random();
	int n = ran.nextInt(500000);
	String SpecName1=SpecName+n;
   item.put("Name",SpecName1);
   item.put("Description","test456367890");
   item.put("Status","Active");
   item.put("StartDate","2020-04-23T00:00:00");
   item.put("EndDate","2020-04-30T00:00:00");
   item.put("PromoCode","");
   item.put("Flyer","");
   item.put("EndBuyerSafeFlyer",false);
	
	array.add(item);
	json.put("", array);
	request.body(array.toJSONString());

 resp=request.post("https://productservice.uat-asicentral.com/api/v4/specials/");
    
   code=resp.getStatusCode();
		
	  System.out.println("Status Code is:"+code);
		
	  //Assert.assertEquals(code, 200);
	 
      String data=resp.asString();
	  
	  System.out.println("Data is:"+data);
	 
}

*/
@SuppressWarnings("unchecked")
@Test(priority=3)	
public void GetAllVideo(){
	 
	//1. define the base url
			//http://restapi.demoqa.com/utilities/weather/city
			RestAssured.baseURI = "https://productservice.uat-asicentral.com/api/v5";
			 request.header("Accept","application/json");
			   
			 request.header("Content-Type","application/json");

			 request.header("AuthToken",AccessToken);	 
			//2. define the http request:
			request=RestAssured.given();
			
			//3. make a request/execute the request:
			resp = request.request(Method.GET, "/videos");
			
			//4. get the response body:
			String responseBody = resp.getBody().asString();
			System.out.println("Response Body is: "+ responseBody);
			//validate city name or validate the key or value
		//	Assert.assertEquals(responseBody.contains("Pune"), true);
			
			//5. get the status code and validate it:
			int statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			
			Assert.assertEquals(statusCode, 200);
}

}