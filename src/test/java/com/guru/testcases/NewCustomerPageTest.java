package com.guru.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.guru.qa.base.TestBase;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewCustomerPage;

public class NewCustomerPageTest extends TestBase {
	LoginPage lp;
	HomePage hp;
	NewCustomerPage ncp;

	public NewCustomerPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException   {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		ncp = new NewCustomerPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(2000);
		ncp = hp.verfyNewCustomerBtn();
		Thread.sleep(2000);
		
	}

	@Test(priority = 1)
	public void verifyHederTest() {
		String header = ncp.verifyPageHeader();
		Assert.assertEquals(header, "Add New Customer");
	}

	@Test(priority = 2)
	public void verifyTitleTest() {
		String title = ncp.verifyTitle();
		Assert.assertEquals(title, "Guru99 Bank New Customer Entry Page");
	}

	
	@Test(priority = 3)
	public void verifyRegistrationForm() {
		ncp.validateRegisterForm(prop.getProperty("name"), prop.getProperty("date"), prop.getProperty("address"),
				prop.getProperty("city"), prop.getProperty("state"), prop.getProperty("pin"), prop.getProperty("mobile"),
				prop.getProperty("email"),prop.getProperty("pass"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
