package Videos;



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

public class GetVideoByID {

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
 


@SuppressWarnings("unchecked")
@Test(priority=1)	
public void PostVideo(){
	 
   request=RestAssured.given();
	
   
   request.header("Accept","application/json");
   
   request.header("Content-Type","application/json");

   request.header("AuthToken",AccessToken);	 
	 

	resp=request.get("https://productservice.uat-asicentral.com/api/v5/videos/91488726");
    
	code=resp.getStatusCode();
		
	System.out.println("Status Code is:"+code);
		
	  //Assert.assertEquals(code, 200);
	 
      String data=resp.asString();
	  
	  System.out.println("Data is:"+data);
	 
}
}