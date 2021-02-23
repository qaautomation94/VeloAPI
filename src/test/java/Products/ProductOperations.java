package Products;



import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Videos.Base;
import Videos.TestData;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.util.IOUtils;

public class ProductOperations extends Base {
	    public static String XID="9207-";
 
@SuppressWarnings("unchecked")
public static void GetProductByXID(){
	 
		Base.Headers();
		System.out.println(ExternalID);
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetProductByXID+ExternalID);
		String responseBody =	 resp.getBody().asString();		 
		System.out.println("Response Body is" + responseBody);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);

}

@SuppressWarnings("unchecked")
public static void DeleteProduct(){
	 
		Base.Headers();
		System.out.println(XID);
		resp =request.request(Method.DELETE, TestData.BaseUrl+TestData.GetProductByXID+XID);
		statusCode=resp.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
	 
      
}

@SuppressWarnings("unchecked")
public static void DeleteProduct1(){
	 
		Base.Headers();
		System.out.println(ExternalID);
		resp =request.request(Method.DELETE, TestData.BaseUrl+TestData.GetProductByXID+ExternalID);
		statusCode=resp.getStatusCode();
		System.out.println("Status Code is:"+statusCode);
		Assert.assertEquals(statusCode, 200);
	 
      
}

@SuppressWarnings("unchecked")
public static void GetDeletedProduct(){
	 
		Base.Headers();
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetProductByXID+ExternalID);
		String responseBody =	 resp.getBody().asString();		 
		System.out.println("Response Body is" + responseBody);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 404);

}

@SuppressWarnings("unchecked")
public static void GetAllProductsAfterDeletion(){
	 	Base.Headers();
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetAllProducts);		
		String responseBody =	 resp.getBody().asString();
		String[] abc =responseBody.split("\"");
		ExternalID =  abc[5];
	 	System.out.println(ExternalID);
		System.out.println("Response Body is" + responseBody);
		String lastFiveChar = responseBody.substring(responseBody.length() - 4);
		System.out.println("the status code is: "+ lastFiveChar);
		String result = lastFiveChar.substring(0, lastFiveChar.length() - 1);
		System.out.println("Product Count is: "+ result);
		ProductCountAfterDeletion = Integer.parseInt(result);
		System.out.println(ProductCountAfterDeletion);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertTrue(ProductCountBeforeDeletion>ProductCountAfterDeletion);
		Assert.assertEquals(statusCode, 200);

	}


@SuppressWarnings("unchecked")
public static void PostProduct() throws IOException, ParseException{
	 
				Base.Headers();
				
				   String fileName = "Json\\product.json";
				   File fileToBeModified = new File(fileName);
				   BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
				   String line = reader.readLine();
				   String oldContent = "";

				   while (line != null)
				   {
				           oldContent = oldContent + line + System.lineSeparator();
				 //          System.out.println(oldContent);
				           line = reader.readLine();
				          
				   }
				   
				   JsonObject jsonObject = new JsonParser().parse(oldContent).getAsJsonObject();
			       String extID = jsonObject.get("ExternalProductId").getAsString();
			       System.out.println(extID);
			       int n = 100000000 + new Random().nextInt(999999999);
			       XID=XID+n;
			       System.out.println(XID);
				   String newContent = oldContent.replaceAll(extID, XID);
				   
			       String Name = jsonObject.get("Name").getAsString();
			       String newName="Automation Test";
			       newContent = newContent.replaceAll(Name, newName);

				   FileWriter writer = new FileWriter(fileToBeModified);
				   writer.write(newContent);
				   reader.close();
				   writer.close();
				   
				
					FileInputStream fis = new FileInputStream(new File("Json\\product.json"));
					
		  resp 			=    given()
				            .accept(ContentType.JSON)
				            .contentType(ContentType.JSON)
				            .header("AuthToken",AccessToken)
				            .body(IOUtils.toByteArray(fis))
				            .request(Method.POST,TestData.BaseUrl+TestData.PostProduct);
		  					statusCode=resp.getStatusCode();
		  					resp.body().asString();
				 			System.out.println("Status response is:"+resp.body().asString());

				 			System.out.println("Status Code is:"+statusCode);
				 			Assert.assertEquals(statusCode, 200);

}			   


@SuppressWarnings("unchecked")
public static void GetAllProducts() throws InterruptedException{
		Thread.sleep(15000);
		Base.Headers();
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetAllProducts);
		String responseBody =	 resp.getBody().asString();
		System.out.println(responseBody);
		/*
		String[] prodlists =responseBody.split("\"");
		System.out.println(prodlists);
		ExternalID =  abc[5];
		System.out.println(ExternalID);
		System.out.println("Response Body is" + responseBody);	
		String lastFiveChar = responseBody.substring(responseBody.length() - 4);
		System.out.println("the status code is: "+ lastFiveChar);
		String result = lastFiveChar.substring(0, lastFiveChar.length() - 1);
		System.out.println("Product Count is: "+ result);
		ProductCountBeforeDeletion = Integer.parseInt(result);
		System.out.println(ProductCountBeforeDeletion);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		*/
		
	 	Gson gson = new Gson();
	 	JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
	 	JsonArray posts = jsonObject.getAsJsonArray("Products");

	 	for (JsonElement post : posts) {
	 	  ExternalID = post.getAsJsonObject().get("ExternalProductId").getAsString();
	 	}
	 	
	 	statusCode = resp.getStatusCode();
	 	Assert.assertEquals(statusCode, 200);

}

/*				
				
				JSONParser parser = new JSONParser();
				try {
					Object obj1 = parser.parse(new FileReader("Json\\product.json"));
		 
					// A JSON object. Key value pairs are unordered. JSONObject supports java.util.Map interface.
					JSONObject jsonObject = (JSONObject) obj1;
		 
					System.out.println(jsonObject.get("ExternalProductId"));
					// A JSON array. JSONObject supports java.util.List interface.
					JSONArray companyList = (JSONArray) jsonObject.get("Categories");
		 
					// An iterator over a collection. Iterator takes the place of Enumeration in the Java Collections Framework.
					// Iterators differ from enumerations in two ways:
					// 1. Iterators allow the caller to remove elements from the underlying collection during the iteration with well-defined semantics.
					// 2. Method names have been improved.
					Iterator<JSONObject> iterator = companyList.iterator();
					while (iterator.hasNext()) {
						System.out.println(iterator.next());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			

	        	
	*/			
							  
@SuppressWarnings("unchecked")
public static void PostProductwithGreaterThanRequiredLengthName() throws IOException, ParseException{
	 
				Base.Headers();
				   String fileName = "Json\\product.json";
				   File fileToBeModified = new File(fileName);
				   BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
				   String line = reader.readLine();
				   String oldContent = "";

				   while (line != null)
				   {
				           oldContent = oldContent + line + System.lineSeparator();
				 //          System.out.println(oldContent);
				           line = reader.readLine();
				          
				   }
				  
				   JsonObject jsonObject = new JsonParser().parse(oldContent).getAsJsonObject();
			       String Name = jsonObject.get("Name").getAsString();
			       
			       
			       String newName="XYZasdfghjklpoiuytrewqzxcvbnmasdfghjklpoiuytrewqzxcvbnmqwertyuijhbjhb";
				   String newContent = oldContent.replaceAll(Name, newName);
				   FileWriter writer = new FileWriter(fileToBeModified);
				   writer.write(newContent);
				   reader.close();
				   writer.close();
				   
					
					FileInputStream fis = new FileInputStream(new File("Json\\product.json"));
					
		  resp 			=    given()
				            .accept(ContentType.JSON)
				            .contentType(ContentType.JSON)
				            .header("AuthToken",AccessToken)
				            .body(IOUtils.toByteArray(fis))
				            .request(Method.POST,TestData.BaseUrl+TestData.PostProduct);
		  					statusCode=resp.getStatusCode();
		  					resp.body().asString();
				 			Assert.assertEquals(statusCode, 400);

}			   




		@SuppressWarnings("unchecked")
		
		public static void PostProductwithSpecialCharacterNme() throws IOException, ParseException{
		
		Base.Headers();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String str1 = RandomStringUtils.random( 15, characters );
		System.out.println( str1 );
		String specialchar = "üéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒ";

		String str2 = RandomStringUtils.random( 15, specialchar );
		System.out.println( str2 );
		String ProdName=str1+str2;
		
		String fileName = "Json\\product.json";
		File fileToBeModified = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
		String line = reader.readLine();
		String oldContent = "";
		
		while (line != null)
		{
		oldContent = oldContent + line + System.lineSeparator();
		//          System.out.println(oldContent);
		line = reader.readLine();
		
		}
		
		JsonObject jsonObject = new JsonParser().parse(oldContent).getAsJsonObject();
		String Name = jsonObject.get("Name").getAsString();
		String newContent = oldContent.replaceAll(Name, ProdName);
		FileWriter writer = new FileWriter(fileToBeModified);
		writer.write(newContent);
		reader.close();
		writer.close();
		
		FileInputStream fis = new FileInputStream(new File("Json\\product.json"));		
		resp 			=    given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.header("AuthToken",AccessToken)
		.body(IOUtils.toByteArray(fis))
		.request(Method.POST,TestData.BaseUrl+TestData.PostProduct);
		statusCode=resp.getStatusCode();
		resp.body().asString();
		Assert.assertEquals(statusCode, 400);
		
				}			   



public static void GetPostedProduct() throws IOException{
	 
			Base.Headers();
			resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetProductByXID+XID);			
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
			List<Integer> ids = resp.jsonPath().getList("Categories");
			System.out.println(ids.get(0));
			String ProdID=resp.jsonPath().getJsonObject("ExternalProductId");
			//System.out.println("XID is"+ ProdID);
			String ProdName=resp.jsonPath().getJsonObject("Name");
			String ProdDesc=resp.jsonPath().getJsonObject("Description");
			String ProdSummary=resp.jsonPath().getJsonObject("Summary");
			String ProdNo=resp.jsonPath().getJsonObject("AsiProdNo");
			
			String fileName = "Json\\product.json";			
			File fileToBeModified = new File(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
			String line = reader.readLine();
			String oldContent = "";

			   while (line != null)
			   {
			           oldContent = oldContent + line + System.lineSeparator();
			           line = reader.readLine();
			          
			   }
			   
			   JsonObject jsonObject = new JsonParser().parse(oldContent).getAsJsonObject();
		       String RespextID = jsonObject.get("ExternalProductId").getAsString();
		       String RespProdName = jsonObject.get("Name").getAsString();
		       String RespProdDesc = jsonObject.get("Description").getAsString();
		       String RespProdSummary = jsonObject.get("Summary").getAsString();
		       String RespProdNo = jsonObject.get("AsiProdNo").getAsString();

		       Assert.assertEquals(ProdID, RespextID);
		       Assert.assertEquals(ProdName, RespProdName);
		       Assert.assertEquals(ProdDesc, RespProdDesc);
		       Assert.assertEquals(ProdSummary, RespProdSummary);
		       Assert.assertEquals(ProdNo, RespProdNo);

					
}


public static void GetAllProductsAfterPosting(){
	 
		Base.Headers();
		resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetAllProducts);
		String responseBody =	 resp.getBody().asString();
		String[] abc =responseBody.split("\"");
		ExternalID =  abc[5];
	 	System.out.println(ExternalID);
		System.out.println("Response Body is" + responseBody);
		String lastFiveChar = responseBody.substring(responseBody.length() - 4);
		System.out.println("the status code is: "+ lastFiveChar);
		String result = lastFiveChar.substring(0, lastFiveChar.length() - 1);
		System.out.println("Product Count is: "+ result);
		ProductCountAfterPosting = Integer.parseInt(result);
		System.out.println(ProductCountAfterPosting);
		statusCode = resp.getStatusCode();
		System.out.println("the status code is: "+ statusCode);
		Assert.assertTrue(ProductCountAfterPosting>ProductCountAfterDeletion);
		Assert.assertEquals(statusCode, 200);

	}


public static void InactiveProduct(){
	 
			Base.Headers();
			resp =request.request(Method.POST,TestData.BaseUrl+TestData.POSTInactivateAProduct_FirstPart+ExternalID+ TestData.POSTInactivateAProduct_SecondPart);
			Assert.assertEquals(statusCode, 200);

}


public static void DeleteInactiveProduct(){
	 
		   Base.Headers();
		   resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetProductByXID+ExternalID);
		   String responseBody =	 resp.getBody().asString();
		   System.out.println("Response Body is" + responseBody);
		   statusCode = resp.getStatusCode();
		   System.out.println("the status code is: "+ statusCode);
		   Assert.assertEquals(statusCode, 200);

	}

}
