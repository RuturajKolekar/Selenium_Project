package com.guru.testcases;

import static Util.extentReports.ExtentTestManager.startTest;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.guru.qa.base.TestBase;
import com.guru.qa.pages.DeleteCustomerPage;
import com.guru.qa.pages.EditCustomerPage;
import com.guru.qa.pages.HomePage;
import com.guru.qa.pages.LoginPage;
import com.guru.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase {

	LoginPage lp;
	HomePage homepage;
	NewCustomerPage newCustomer;
	EditCustomerPage editCustomer;
	DeleteCustomerPage deleteCustomer;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		newCustomer = new NewCustomerPage();
		editCustomer = new EditCustomerPage();
		deleteCustomer = new DeleteCustomerPage();
		homepage = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyManagerIDTest(Method method) {
		startTest(method.getName(), "validteManagerID");
		String mangerID = homepage.validteManagerID();
		Assert.assertEquals(mangerID, "Manger Id : mngr401152");
	}
	
	@Test(priority = 0)
	public void verifyTitleTest(Method method) {
		startTest(method.getName(), "Getting Title");
		String title = homepage.validatetitle();
		Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
	}

	@Test(priority = 2)
	public void verifyNewCustomerTest(Method method) {
		startTest(method.getName(), "verfyNewCustomerBtn");
		 newCustomer = homepage.verfyNewCustomerBtn();
	}

	@Test(priority = 3)
	public void verifyEditCustomerTest(Method method) {
		startTest(method.getName(), "verfyEditCustomerBtn");
		 editCustomer = homepage.verfyEditCustomerBtn();
	}

	@Test(priority = 4)
	public void verifyDeleteCustomerTest(Method method) {
		startTest(method.getName(), "verfyDeleteCustomerBtn ");
		 deleteCustomer = homepage.verfyDeleteCustomerBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
