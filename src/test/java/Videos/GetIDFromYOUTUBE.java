package Videos;



import java.util.Arrays;
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

public class GetIDFromYOUTUBE {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int code;
	public static String data;
	String AccessToken;
	

@SuppressWarnings("unchecked")
@Test(priority=1)	
public void PostVideo(){
	 
   request=RestAssured.given();
	
   
   request.header("Accept","application/json");
   
   request.header("Content-Type","application/json");

 //  request.header("AuthToken",AccessToken);	 
	 

	resp=request.get("https://www.googleapis.com/youtube/v3/search?key=AIzaSyCBDqlf23kZZ_4RzSsvLFNkYdo_KLxo9bc&maxResults=50&part=snippet&type=video&q=jXm");
    
	code=resp.getStatusCode();
		
	System.out.println("Status Code is:"+code);
		
	  //Assert.assertEquals(code, 200);
	 
      String data=resp.asString();
//      System.out.println(data);



		  String[] abc =data.split("videoId");
		  int a= abc.length;
		  System.out.println(a);
		  
		  Random rand = new Random(); 
		  
	        // Generate random integers in range 0 to 999 
	        int rand_int1 = rand.nextInt(a-1); 
	        AccessToken =  abc[rand_int1];
			  String VID_ID=AccessToken.substring(4, 15);

			  System.out.println(VID_ID);  
	        
		  /*
		  for(int m=1; m<a; m++) {
			  AccessToken =  abc[m];
			  String VID_ID=AccessToken.substring(4, 15);

			  System.out.println(VID_ID);  
  
		  }
		  
		  System.out.println(AccessToken);

		  System.out.println("Iftikhar2");

		  System.out.println(abc[0]);
		  System.out.println("Iftikhar3");

		 	  System.out.println("Data is:"+data);
		 */
}

}
