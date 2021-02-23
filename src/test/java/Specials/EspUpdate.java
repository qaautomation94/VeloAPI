package Specials;



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
import io.restassured.http.Method;
import io.restassured.path.xml.mapping.XmlPathObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EspUpdate {
	
//		static String YoutubeURL="https://www.googleapis.com/youtube/v3/search?key=AIzaSyA-MFl3pBXEA72uRRWNlvYbo7mf27Mhcgg&maxResults=50&part=snippet&type=video&q=jXm";

		static String YoutubeURL="https://www.googleapis.com/youtube/v3/search?pageToken=CEsQAA&key=AIzaSyA-MFl3pBXEA72uRRWNlvYbo7mf27Mhcgg&maxResults=50&part=snippet&type=video&q=jXm";
	public static String BaseUrl="https://productservice.asicentral.com/";

	public static String GetAllProducts="api/v5/products/";
	public static String GetProductByXID="api/v5/products/";
	public static String PostProduct="api/v5/products/";
	public static String POSTInactivateAProduct_FirstPart="api/v5/products/";
	public static String POSTInactivateAProduct_SecondPart="/inactivate";
	
	static String GetAllSpecials="api/v5/specials/";
	static String GetSpecialsByID="api/v5/specials/";
	public static String PostSpecial="api/v5/specials/";


	static String PostVideo="api/v5/videos/";
	static String GetAllVideo="api/v5/videos/";
	static String GetVideoByID="api/v5/videos/";
	static String DeleteVideoByID="api/v5/videos/";

	

	

	


	

}