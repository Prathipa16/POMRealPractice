package com.lao.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePage {

	@FindBy(xpath="//span[text()='Admin']")
	public static WebElement adminClick;
	
	@FindBy(xpath="//span[text()='User Management ']")
	public static WebElement usermanagementCLick;
	
	@FindBy(xpath="//a[text()='Users']")
	public static WebElement userClick;
	
	
	@FindBy(xpath="//div[text()='-- Select --']")
	public static WebElement SelectUserRole;


	@FindBy(xpath="(//div[contains(text(),'-- Select --')])[1]")
	public static WebElement SelecStatus;	
	
	
	@FindBy(xpath="(//button[normalize-space()='Search']")
	public static WebElement submitClick;
	
	@FindBy(xpath="((//div[contains(text(),'Admin')])[3]")
	public static WebElement userRoleEnabled;
	
	@FindBy(xpath="(//div[contains(text(),'Enabled')])[2]")
	public static WebElement statusEnabled;
	
	
}
