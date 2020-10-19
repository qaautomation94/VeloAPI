package Videos;



import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.RestAssured;
import io.restassured.config.ParamConfig;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Method;
import io.restassured.path.xml.mapping.XmlPathObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base {

	public static RequestSpecification request;
	public static JSONObject json;
	public static Response resp;
	public static int statusCode;
	public static String data;
	protected static String AccessToken;
	protected static String GetVideoID;
	static String PostedVideoID;
	protected static String ExternalID="0001ASI-test";
	protected static int ProductCountBeforeDeletion;
	protected static int ProductCountAfterDeletion;
	protected static int ProductCountAfterPosting;


	protected String VideoCountBeforePosting;
	protected String VideoCountAfterPosting;
	protected String VideoCountAfterDeletion;
	public static String accessToken;


	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static JSONArray array;
	protected static JSONObject item;
	
 @SuppressWarnings("unchecked")
 @BeforeSuite
 public void TokenGeneration(){
	
	 
 
    request=RestAssured.given();
	request.header("Content-Type","application/json");
	json=new JSONObject();

	json.put("Asi","33020");
    json.put("Username", "Api_Automation");
    json.put("Password", "test1234");
	request.body(json.toJSONString());
	resp=request.post("https://productservice.asicentral.com/api/v5/Login");
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
 
 @BeforeClass
 public void ExtentReport(){
 
	ExtentHtmlReporter htmlReporter;
		htmlReporter = new ExtentHtmlReporter("./Reports/"+"VeloApi.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Iftikhar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Muhammad Iftikhar");
		extent.setSystemInfo("URL", TestData.BaseUrl);
//		extent.setReportUsesManualConfiguration(true);
		htmlReporter.config().setDocumentTitle("Velocity API Automation Testing Report");
		htmlReporter.config().setReportName("Velocity API Automation Testing Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();
		
 }
 
 public static void Headers(){
	  	request=RestAssured.given();
		request.header("Accept","application/json");
		request.header("Content-Type","application/json");
		request.header("AuthToken",AccessToken);	 
 }
 @AfterMethod

	public void getResult(ITestResult result ) throws IOException, InterruptedException{
	
	 test = extent.createTest(result.getName());
	
		if(result.getStatus()==ITestResult.SUCCESS){
				test.log(Status.PASS, result.getMethod().getDescription());
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
				test.log(Status.PASS, " Please see attached screenshot");
	 
 			extent.flush();
				}

			
			if(result.getStatus()==ITestResult.FAILURE){

		 	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
	
	 		test.fail(result.getThrowable());
	 		extent.flush();
	 		}
			 			
			
			if(result.getStatus()==ITestResult.SKIP){
				System.out.print("Test cases is skipped");
			 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
			 test.skip(result.getThrowable());
		    }				 		
			
	 }
	
}