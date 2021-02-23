package Price;



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

public class PriceOperations extends Base {
	    public static String XID="9207-";
	    public static Integer PriceGridID;
 
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
public static void PostPriceGrid() throws IOException, ParseException{
	 
				Base.Headers();
				/*
				   String fileName = "Json\\pricegrid.json";
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
				   
				*/
					FileInputStream fis = new FileInputStream(new File("Json\\pricegrid.json"));
					
		  resp 			=    given()
				            .accept(ContentType.JSON)
				            .contentType(ContentType.JSON)
				            .header("AuthToken",AccessToken)
				            .body(IOUtils.toByteArray(fis))
				            .request(Method.POST,TestData.BaseUrl+"api/v5/products/"+XID+"/prices");
		  					statusCode=resp.getStatusCode();
		  					resp.body().asString();
				 			System.out.println("Status response is:"+resp.body().asString());

				 			System.out.println("Status Code is:"+statusCode);
				 			Assert.assertEquals(statusCode, 200);

}			   



public static void GetAllPriceGrids() throws IOException{
	 
			Base.Headers();
			String url = TestData.BaseUrl + "api/v5/products/"+XID+"/prices";
		//	resp =request.request(Method.GET, TestData.BaseUrl+TestData.GetProductByXID+XID);
			resp =request.request(Method.GET, url);			
			String responseBody =	 resp.getBody().asString();
			System.out.println(responseBody);
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
			List<Integer> ids = resp.jsonPath().getList("ID");
			PriceGridID = ids.get(0);
		
		//	System.out.println(ids.get(0));
//			String ProdID=resp.jsonPath().getJsonObject("ID");
//			System.out.println("XID is"+ ProdID);
//			String ProdName=resp.jsonPath().getJsonObject("Name");
//			String ProdDesc=resp.jsonPath().getJsonObject("Description");
//			String ProdSummary=resp.jsonPath().getJsonObject("Summary");
//			String ProdNo=resp.jsonPath().getJsonObject("AsiProdNo");
//			
//			String fileName = "Json\\product.json";			
//			File fileToBeModified = new File(fileName);
//			BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified));
//			String line = reader.readLine();
//			String oldContent = "";
//
//			   while (line != null)
//			   {
//			           oldContent = oldContent + line + System.lineSeparator();
//			           line = reader.readLine();
//			          
//			   }
//			   
//			   JsonObject jsonObject = new JsonParser().parse(oldContent).getAsJsonObject();
//		       String RespextID = jsonObject.get("ExternalProductId").getAsString();
//		       String RespProdName = jsonObject.get("Name").getAsString();
//		       String RespProdDesc = jsonObject.get("Description").getAsString();
//		       String RespProdSummary = jsonObject.get("Summary").getAsString();
//		       String RespProdNo = jsonObject.get("AsiProdNo").getAsString();
//
//		       Assert.assertEquals(ProdID, RespextID);
//		       Assert.assertEquals(ProdName, RespProdName);
//		       Assert.assertEquals(ProdDesc, RespProdDesc);
//		       Assert.assertEquals(ProdSummary, RespProdSummary);
//		       Assert.assertEquals(ProdNo, RespProdNo);
//
					
}




public static void GetSinglePriceGrid() throws IOException{
	 
			Base.Headers();
			String PriceGrid=Integer.toString(PriceGridID);  

			String url = TestData.BaseUrl + "api/v5/products/"+XID+"/prices/"+PriceGrid;
			resp =request.request(Method.GET, url);			
			String responseBody =	 resp.getBody().asString();
			System.out.println(responseBody);
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
}

public static void DeleteSinglePriceGrid() throws IOException{
	 
	Base.Headers();
	String PriceGrid=Integer.toString(PriceGridID);  

	String url = TestData.BaseUrl + "api/v5/products/"+XID+"/prices/"+PriceGrid;

	resp =request.request(Method.DELETE, url);
	statusCode=resp.getStatusCode();
	System.out.println("Status Code is:"+statusCode);
	Assert.assertEquals(statusCode, 200);

}

}
