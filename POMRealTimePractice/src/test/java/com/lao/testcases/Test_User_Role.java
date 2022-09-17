package com.lao.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lao.commonfunctions.CommonFunctions;
import com.lao.pom.LoginPage;
import com.lao.pom.UserRolePage;

public class Test_User_Role extends CommonFunctions {
	
	private static final Logger LOGGER = LogManager.getLogger(Test_User_Role.class);
	
	
	@Test
	public static void MoveTouserPage() throws InterruptedException{
		Thread.sleep(2000);

		PageFactory.initElements(driver,UserRolePage.class);
		Thread.sleep(2000);
		UserRolePage.adminClick.click();
		Thread.sleep(2000);
		LOGGER.info("clicks admin");
		UserRolePage.usermanagementCLick.click();
		Thread.sleep(2000);
		LOGGER.info("clicks usermanagement");
		UserRolePage.userClick.click();
		LOGGER.info("clicks .user");
	}
    
	
	@Test
	public static void slectUserRole() throws AWTException, InterruptedException
	{
		UserRolePage.SelectUserRole.click();
		Thread.sleep(2000);
		Robot rb = new Robot();
		for (int i=0;i<1;i++)
		{
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);	

		LOGGER.info("Selected Admin");
		
		
		
		
	}
	
	@Test
	public static void slectStatus() throws AWTException, InterruptedException
	{
		UserRolePage.SelecStatus.click();
		Thread.sleep(2000);
		Robot rb = new Robot();
		for (int i=0;i<1;i++)
		{
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
		}
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);	
		
		LOGGER.info("Selected Enabled");
 
		}
	
	
	
	@Test
	public static void searchClick() throws InterruptedException
	{
		
	Thread.sleep(3000);
	UserRolePage.submitClick.click();
	
	String actualRole = UserRolePage.userRoleEnabled.getText();
	String actualStatus = UserRolePage.statusEnabled.getText();
	
	Assert.assertEquals(actualRole, "Admin");
	Assert.assertEquals(actualStatus, "Enabled");
	}
	
	
	@Test
	public static void CheckUserRole() throws InterruptedException, AWTException
	{
		Thread.sleep(3000);
		PageFactory.initElements(driver,UserRolePage.class);
		MoveTouserPage();
		slectUserRole();
		slectStatus();
		searchClick();
		
	}
	
}
