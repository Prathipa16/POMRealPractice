package com.lao.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(name="username")
	public static WebElement userName;
	
	@FindBy(name="password")
	public static WebElement passWord;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	public static WebElement loginBtn;

}
