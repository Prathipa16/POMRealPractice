package com.lao.commonfunctions;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	static ExtentReports extentreport;
	static ExtentSparkReporter htmlReporter;
	
	private static final Logger LOGGER = LogManager.getLogger(CommonFunctions.class);
	
	public static Properties prop=null;
	
	public static WebDriver driver=null;

	public  Properties loadPropertyFile() throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\POMRealTimePractice\\src\\test\\resources\\config.properties");
		
		LOGGER.info("Initializing Prop file");
		
		 prop = new Properties();
		
		prop.load(file);
		return prop;
		
	}
	
@BeforeSuite	
public  void launchBrowser() throws IOException, InterruptedException
{
	setExtent();
	LOGGER.info("Loading Prop file");
	loadPropertyFile();
	String browser = prop.getProperty("Browser");
	String url = prop.getProperty("App_URL");
	String user = prop.getProperty("UserName");
	String pass = prop.getProperty("Password");
	
	if (browser.equalsIgnoreCase("chrome"))
	{
		LOGGER.info("Launching chrome Browser");
		WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
	}else if (browser.equalsIgnoreCase("edge"))
		{
		LOGGER.info("Launching edge Browser");
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		}
	driver.manage().window().maximize();
	LOGGER.info("Loading URL");
	driver.get(url);
	Thread.sleep(3000);
//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
}

public static void setExtent() {
	htmlReporter = new ExtentSparkReporter("C:\\Users\\Lenovo\\eclipse-workspace\\POMRealTimePractice\\src\\test\\resources\\ExtenReport.html");
	htmlReporter.config().setDocumentTitle("Automation Report");
	htmlReporter.config().setReportName("Extent Report");
	
	
	htmlReporter.config().setTheme(Theme.DARK);
	extentreport  = new ExtentReports();
	extentreport.attachReporter(htmlReporter);
	extentreport.setSystemInfo("HostName", "LocalHost");
	extentreport.setSystemInfo("OS", "Windwos10");
	extentreport.setSystemInfo("TesterName", "Preethi");
	extentreport.setSystemInfo("Browser", "Chrome");
	}


@AfterSuite
public void browserClose() throws InterruptedException, IOException {
		
	Thread.sleep(3000);
	LOGGER.info("Closing Browser");	
driver.quit();

extentreport.flush();
Desktop.getDesktop().browse(new File("C:\\Users\\Lenovo\\eclipse-workspace\\POMRealTimePractice\\src\\test\\resources\\ExtenReport.html").toURI());
LOGGER.info("Report Generated");

}
}
