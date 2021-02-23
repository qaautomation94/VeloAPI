package Videos;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.http.Method;

public class VideosAPIs  extends Base{
	String VideoIDAssociateWithProduct;
	String responseBody;
	String GetAssociatedExternalID;
	

@Test(priority=1)	
public void GetAllVideoBeforePosting(){
	 
			Base.Headers();
			resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetAllVideo);
			String responseBody =	 resp.getBody().asString();

	 		Gson gson = new Gson();
		 	JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
		 	JsonArray posts = jsonObject.getAsJsonArray("Videos");

		 	for (JsonElement post : posts) {
		 		GetVideoID = post.getAsJsonObject().get("ID").getAsString();
		 	  System.out.println(GetVideoID);
		 	}


		 	statusCode = resp.getStatusCode();
		 	Assert.assertEquals(statusCode, 200);
	 		
			// Method 1: parsing into a JSON element
			jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();
			VideoCountBeforePosting=jsonObject.get("TotalCount").getAsString();
			System.out.println(VideoCountBeforePosting);
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
			
}

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
			
			String responseBody =	 resp.getBody().asString();
			

			Gson gson = new Gson();
		 	JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
		 	JsonArray posts = jsonObject.getAsJsonArray("items");

		 	int a=posts.size();
		 	Random rand = new Random();
			int randomno= rand.nextInt(a);
			List<String> zoom = new ArrayList<>();


		 	for (JsonElement post : posts) {
		 					 GetVideoID =  post.getAsJsonObject().get("id").getAsJsonObject().get("videoId").getAsString();
		 					zoom.add(GetVideoID);
		 					 System.out.println(GetVideoID);  
		 	
		 					 System.out.println(zoom.get(0));  
		 	}
		 	

			GetVideoID=zoom.get(randomno);
		  	
		  	System.out.println("URL is "+"https://www.youtube.com/watch?v="+GetVideoID);
		  	item.put("URL", "https://www.youtube.com/watch?v="+GetVideoID);
		  	item.put("Description", "Test Videos and Iftikhar");
		  	array.add(item);
		  	json.put("", array);
		  	request.body(array.toJSONString());
		//  resp=request.post(TestData.BaseUrl+TestData.PostVideo);
			resp =request.request(Method.POST,TestData.BaseUrl+TestData.PostVideo);
			statusCode=resp.getStatusCode();
			System.out.println("Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 201);

}


@SuppressWarnings("unchecked")
@Test(priority=3)	
public void GetAllVideoAfterPostingNewVideo(){
	 
	Base.Headers();
	resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetAllVideo);
	String responseBody =	 resp.getBody().asString();

		Gson gson = new Gson();
 	JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
 	JsonArray posts = jsonObject.getAsJsonArray("Videos");

 	for (JsonElement post : posts) {
 		PostedVideoID = post.getAsJsonObject().get("ID").getAsString();
 	  System.out.println(GetVideoID);
 	}


 	statusCode = resp.getStatusCode();
 	Assert.assertEquals(statusCode, 200);
		
	// Method 1: parsing into a JSON element
	jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();
	VideoCountAfterPosting=jsonObject.get("TotalCount").getAsString();
	System.out.println(VideoCountAfterPosting);
	statusCode = resp.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 200);

}


	@SuppressWarnings("unchecked")
	@Test(priority=4)	
		public void GetVideoByID(){
			Base.Headers();
			resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetVideoByID+PostedVideoID);
			String responseBody =	 resp.getBody().asString();
			System.out.println("Response Body is for video" + responseBody);
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
			
}

	
	@SuppressWarnings("unchecked")
	@Test(priority=5)	
		public void GetProIDAssociatedByVideo() throws IOException, ParseException{
			Base.Headers();
			resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetAllVideo);
			String responseBody1 =	 resp.getBody().asString();
			Gson gson = new Gson();
		 	JsonObject jsonObject = gson.fromJson(responseBody1, JsonObject.class);
		 	JsonArray posts = jsonObject.getAsJsonArray("Videos");
		 	for (JsonElement post : posts) {
		 		GetVideoID = post.getAsJsonObject().get("ID").getAsString();
		 		System.out.println(GetVideoID);
				VideoIDAssociateWithProduct = GetVideoID;
				System.out.println(VideoIDAssociateWithProduct);
				System.out.println("Loop for product "+ post);
				resp =request.request(Method.GET, TestData.BaseUrl+"/api/v5/videos/"+VideoIDAssociateWithProduct+"/products");
				responseBody =	 resp.getBody().asString();
				System.out.println(responseBody);
				if(responseBody.contains("ExternalProductId")) {
					break;
				}
		 		
			}
		 	
		 	JsonArray json = gson.fromJson(responseBody, JsonArray.class);
		 	 
		 	System.out.println(posts);

		 	for (JsonElement post : json) {
		 		GetAssociatedExternalID = post.getAsJsonObject().get("ExternalProductId").getAsString();
		 	}
		 	
		 	
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
						
}
	
	@SuppressWarnings("unchecked")
	@Test(priority=6)	
	public void RemoveProductFromAVideo(){
				Base.Headers();

				//Remove Single Product
				resp =request.request(Method.DELETE, TestData.BaseUrl+"api/v5/videos/"+VideoIDAssociateWithProduct+"/products/"+GetAssociatedExternalID);
				statusCode=resp.getStatusCode();
				System.out.println("Delete Status Code is:"+statusCode);
				Assert.assertEquals(statusCode, 201);
	}
	
	
	@SuppressWarnings("unchecked")
	@Test(priority=7)	
	public void GetVideoTypes(){
				Base.Headers();

				
				resp =request.request(Method.GET, TestData.BaseUrl+"/api/v5/lookup/videotype");
				responseBody =	 resp.getBody().asString();
				System.out.println(responseBody);
				Assert.assertEquals(statusCode, 201);
		
	}

	
@SuppressWarnings("unchecked")
@Test(priority=8)	
public void DeleteVideo(){
			Base.Headers();
			resp =request.request(Method.DELETE, TestData.BaseUrl+TestData.DeleteVideoByID+GetVideoID);
			statusCode=resp.getStatusCode();
			System.out.println("Delete Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 200);
}

@SuppressWarnings("unchecked")
@Test(priority=9)	
	public void GetDeletedVideo(){
		Base.Headers();
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetVideoByID+GetVideoID);
		String responseBody =	 resp.getBody().asString();
		System.out.println("Response Body is" + responseBody);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 404);

}

@Test(priority=10)	
public void GetAllVideoAfterDeletion(){
	 
	
	Base.Headers();
	resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetAllVideo);
	String responseBody =	 resp.getBody().asString();

		Gson gson = new Gson();
 	JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
 	JsonArray posts = jsonObject.getAsJsonArray("Videos");

 	for (JsonElement post : posts) {
 		GetVideoID = post.getAsJsonObject().get("ID").getAsString();
 	  System.out.println(GetVideoID);
 	}


 	statusCode = resp.getStatusCode();
 	Assert.assertEquals(statusCode, 200);
		
	// Method 1: parsing into a JSON element
	jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();
	VideoCountAfterDeletion=jsonObject.get("TotalCount").getAsString();
	System.out.println(VideoCountBeforePosting);
	statusCode = resp.getStatusCode();
	System.out.println("the status code is: "+ statusCode);
	Assert.assertEquals(statusCode, 200);

	

	}


}