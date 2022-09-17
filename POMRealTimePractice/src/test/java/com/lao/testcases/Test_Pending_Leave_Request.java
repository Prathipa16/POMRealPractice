package com.lao.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;
import com.lao.pom.DashBoardPage;
import com.lao.pom.LoginPage;

public class Test_Pending_Leave_Request extends CommonFunctions
{
	
	private static final Logger LOGGER = LogManager.getLogger(Test_Pending_Leave_Request.class);
	
	public static String actualmessage;
	
	@Test
	public static void login() throws InterruptedException
	{
		PageFactory.initElements(driver,LoginPage.class);
		Thread.sleep(2000);
		LoginPage.userName.sendKeys(prop.getProperty("UserName"));
		Thread.sleep(2000);
		LOGGER.info("Entered username");
		LoginPage.passWord.sendKeys(prop.getProperty("Password"));
		Thread.sleep(2000);
		LOGGER.info("Entered Password");
		LoginPage.loginBtn.click();
		Thread.sleep(2000);
		LOGGER.info("Click Login");
		
	}
	@Test
	public void getPendingRequest() throws InterruptedException
	{
		
		Thread.sleep(3000);
		login();
		LOGGER.info("Calling Login method");
		Thread.sleep(2000);
		PageFactory.initElements(driver, DashBoardPage.class);
		Thread.sleep(2000);
		DashBoardPage.LaunchingSoon.click();
		LOGGER.info("Click DashBoard");
		 actualmessage =  DashBoardPage.LaunchingSoon.getText();
		 Assert.assertNotEquals(actualmessage, "Launching Soon");
		 LOGGER.info("Assert passed");
	}
@Test
public  void verifypendingLeaveRequest() throws InterruptedException
{
	
	Thread.sleep(3000);
	login();
	LOGGER.info("Calling Login method");
	getPendingRequest();
	LOGGER.info("Calling getPendingRequest method");
	
	
	
	
	
	
}

}
