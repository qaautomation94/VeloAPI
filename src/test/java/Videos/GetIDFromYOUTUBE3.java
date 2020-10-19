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

public class GetIDFromYOUTUBE3 extends Base {

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
	
   


 //  request.header("AuthToken",AccessToken);	 
	 //AIzaSyCBDqlf23kZZ_4RzSsvLFNkYdo_KLxo9bc

   
   https://www.googleapis.com/youtube/v3/search?pageToken=CBkQAA&part=snippet&maxResults=25&order=relevance&q=site%3Ayoutube.com&topicId=%2Fm%2F02vx4&key={YOUR_API_KEY}


	resp=request.get("https://www.googleapis.com/youtube/v3/search?pageToken=CEsQAA&key=AIzaSyA-MFl3pBXEA72uRRWNlvYbo7mf27Mhcgg&maxResults=50&part=snippet&type=video&q=jXm");

	code=resp.getStatusCode();
		
	System.out.println("Status Code is:"+code);
		
	  //Assert.assertEquals(code, 200);
	 
      String data=resp.asString();
      System.out.println(data);




	
}

}
