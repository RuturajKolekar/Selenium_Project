package com.guru.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;

import Util.logs.Log;
import static Util.extentReports.ExtentTestManager.startTest;



public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homepage;
	

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 1, description = "Invalid Login Scenario with wrong username and password.")
	
	public void loginPageTitleTest(Method method) {
		 startTest(method.getName(), "Getting Title");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	
	@Test(priority = 2)
	public void logoTest(Method method) {
		startTest(method.getName(), "Getting Logo");
		boolean  isAvilable=loginPage.validateLogo();
		Assert.assertTrue(isAvilable);
	}
	
	@Test(priority = 3)
	public void loginTest(Method method) {
		startTest(method.getName(), "Redirecting to HomePage");
		 homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
     
	@AfterMethod
	public void tearDown() {
		Log.info("Tests are ending!");
		driver.quit();
	}
}
