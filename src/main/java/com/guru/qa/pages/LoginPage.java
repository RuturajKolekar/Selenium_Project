package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//1.Page Factory || Object Repository
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login_btn;
	
	@FindBy(xpath="//img[@alt='Guru99 Demo Sites']")
	WebElement logo;
	
	
	//2.Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//3.Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un ,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		login_btn.click();
		
		return new HomePage();
	}
	
	
	
	

}
