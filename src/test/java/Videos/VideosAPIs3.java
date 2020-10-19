package Videos;



import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class VideosAPIs3  extends Base{
	String VideoIDAssociateWithProduct;
	String responseBody;
	String GetAssociatedExternalID;
	

@SuppressWarnings("unchecked")
@Test(priority=2, description="In this Api we are posting a youtube video on Esp Update")	
public static void PostVideo(){
	 
			Base.Headers();
			array = new JSONArray();
			item = new JSONObject();
			String VidName="Auto Video";
			Random ran = new Random();
			int n = ran.nextInt(500000);
			String VidName1=VidName+n;
			item.put("Name", VidName1);
			item.put("Type", "PRODUCT");
			resp=request.get(TestData.YoutubeURL);
			String data=resp.asString();
			String[] abc =data.split("videoId");
	  		int a= abc.length;	  
	  		Random rand = new Random(); 
	  
        // Generate random integers in range 0 to 999 
          	int rand_int1 = rand.nextInt(a); 
          	GetVideoID =  abc[rand_int1];
		  	GetVideoID=GetVideoID.substring(4, 15);

		  	System.out.println(GetVideoID);  
		  	System.out.println("URL is "+"https://www.youtube.com/watch?v="+GetVideoID);
		  	item.put("URL", "https://www.youtube.com/watch?v="+GetVideoID);
		  	item.put("Description", "Test Videos and Iftikhar");
		  	array.add(item);
		  	json.put("", array);
		  	request.body(array.toJSONString());
		//  resp=request.post(TestData.BaseUrl+TestData.PostVideo);
			resp =request.request(Method.POST,TestData.BaseUrl+TestData.PostVideo);
			String data1=resp.asString();
			System.out.println("data1  is:"+data1);
			String PostedVideoID=data1.substring(data1.lastIndexOf("videoId") + 8, data1.lastIndexOf("videoId") + 16);
			System.out.println("Status Code is:"+PostedVideoID);
			System.out.println(GetVideoID);
			statusCode=resp.getStatusCode();
			System.out.println("Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 201);

}

@SuppressWarnings("unchecked")
@Test(priority=3, description="In this Api we are posting a youtube video on Esp Update")	
public static void PostProduct(){
	
			Base.Headers();
			array = new JSONArray();
			item = new JSONObject();
			String jsonxyz="{\r\n" + 
					"   \"ExternalProductId\" : \"9529-55103567611\",\r\n" + 
					"   \"Name\" : \"Plz. do not use Plz. do not use Plz. do not e\",\r\n" + 
					"   \"Description\" : \"Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description Full Description e\",\r\n" + 
					"   \"Summary\" : \"Summary Description Summary Description Summary Description Summary Description Summary Description Summary Description Summaryy e\",\r\n" + 
					"   \"AsiProdNo\" : \"11111111111112\",\r\n" + 
					"   \"Inventory\" : {\r\n" + 
					"      \"InventoryLink\" : \"\",\r\n" + 
					"      \"InventoryStatus\" : \"IN STOCK\",\r\n" + 
					"      \"InventoryQuantity\" : \"25\"\r\n" + 
					"   },\r\n" + 

					"}";
		  	array.add(jsonxyz);
		  	json.put("", array);
		  	request.body(array.toJSONString());
			resp =request.request(Method.POST,TestData.BaseUrl+TestData.PostProduct);
			String data1=resp.asString();
			System.out.println("data1  is:"+data1);
			statusCode=resp.getStatusCode();
			System.out.println("Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 201);

	}

}