package Specials;



import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Specials.Base;
import Videos.TestData;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

public class SpecialsAPIs  extends Base{
	String VideoIDAssociateWithProduct;
	String responseBody;
	String GetAssociatedExternalID;
	
	
@Test(priority=1)	
public void GetAllSpecials(){
	 
			Base.Headers();
			resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetAllSpecials);
			String responseBody =	 resp.getBody().asString();
			System.out.println(responseBody);
			String[] abc =responseBody.split("\"");
			GetVideoID =  abc[2];
		 	System.out.println(GetVideoID);
			GetVideoID= GetVideoID.replaceAll("[^0-9]", "");
		 	System.out.println(GetVideoID);
		 		
				

				
			}



@Test(priority=2)	
public void GetSpecialByID(){
	 
			Base.Headers();
			resp =request.request(Method.GET,TestData.BaseUrl+TestData.GetSpecialsByID+GetVideoID);
			String responseBody =	 resp.getBody().asString();
			System.out.println("Response Body is for video" + responseBody);
			statusCode = resp.getStatusCode();
			System.out.println("the status code is: "+ statusCode);
			Assert.assertEquals(statusCode, 200);
				

				
			}

/*

@SuppressWarnings("unchecked")
@Test(priority=7)	
public void PostProduct(){
	 
				Base.Headers();
	
		
	  String payload =          "{\r\n" + 
	  		"	\"Id\":13125,\r\n" + 
	  		"	\"TypeCode\":\"AMTO\",\r\n" + 
	  		"	\"Name\":\"Patching 223\",\r\n" + 
	  		"	\"Description\":\"23232\",\r\n" + 
	  		"	\"Status\":\"Active\",\r\n" + 
	  		"	\"StartDate\":\"2020-06-07T00:00:00\",\r\n" + 
	  		"	\"EndDate\":\"2020-06-30T00:00:00\",\r\n" + 
	  		"	\"PromoCode\":\"\",\r\n" + 
	  		"	\"Flyer\":\"\",\r\n" + 
	  		"	\"CurrencyCode\":\"USD\",\r\n" + 
	  		"	\"EndBuyerSafeFlyer\":false\r\n" + 
	  		"}";
	  
			   
	  resp 			=    given()
			            .accept(ContentType.JSON)
			            .contentType(ContentType.JSON)
			            .header("AuthToken",AccessToken)
			            .body(payload)
			            
			            .request(Method.POST,TestData.BaseUrl+TestData.PostSpecial);
	  					statusCode=resp.getStatusCode();
			 			System.out.println("Status Code is:"+statusCode);
			 			Assert.assertEquals(statusCode, 200);

			             
			    }
*/
		/*		

@SuppressWarnings("unchecked")
@Test(priority=8)	
public void DeleteVideo(){
			Base.Headers();
			resp =request.request(Method.DELETE, TestData.BaseUrl+TestData.DeleteSpecial+GetVideoID);
			statusCode=resp.getStatusCode();
			System.out.println("Delete Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 200);
}




@SuppressWarnings("unchecked")
@Test(priority=10)	
public void ProductAssociatedWithSpecials(){
			Base.Headers();
			resp =request.request(Method.GET, TestData.BaseUrl+TestData.PostSpecial+"13236"+"/products");
			statusCode=resp.getStatusCode();
			System.out.println("Delete Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 200);			
			String responseBody =	 resp.getBody().asString();
			System.out.println(responseBody);
}
*/
@SuppressWarnings("unchecked")
@Test(priority=11)	
public void PostAddProductToSpecial(){
			Base.Headers();
			resp =request.request(Method.DELETE, TestData.BaseUrl+TestData.PostSpecial+"13236"+"/products");
			statusCode=resp.getStatusCode();
			System.out.println("Delete Status Code is:"+statusCode);
			Assert.assertEquals(statusCode, 200);			
			String responseBody =	 resp.getBody().asString();
			System.out.println(responseBody);
}



}
