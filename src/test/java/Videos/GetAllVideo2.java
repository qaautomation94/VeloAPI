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

public class GetAllVideo2 {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int statusCode;
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
	 	resp =request.request(Method.POST, "https://productservice.uat-asicentral.com/api/v4/Login");
	 	
	 	statusCode=resp.getStatusCode();
	 	System.out.println("Status Code is:"+statusCode);
	 	Assert.assertEquals(statusCode, 200);
	 	
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
	 
		request = RestAssured.given();
		request.header("Accept","application/json");
		request.header("Content-Type","application/json");
		request.header("AuthToken",AccessToken);
		
		resp =request.request(Method.GET, "https://productservice.uat-asicentral.com/api/v5/videos/");
		
		String responseBody =	 resp.getBody().asString();
		System.out.println("Response Body is" + responseBody);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);

}
}