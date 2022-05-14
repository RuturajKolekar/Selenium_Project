package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[normalize-space()='Manger Id : mngr401152']")
	WebElement manager_id;

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	WebElement newCustomer;

	@FindBy(xpath = "//a[normalize-space()='Edit Customer']")
	WebElement editCustomer;

	@FindBy(xpath = "//a[normalize-space()='Delete Customer']")
	WebElement deleteCustomer;



	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatetitle() {
	     return driver.getTitle();	
	}
	
	public String validteManagerID() {
		return manager_id.getText();
	}
	
	public NewCustomerPage verfyNewCustomerBtn() {
		newCustomer.click();
		return new NewCustomerPage();
	}
	
	public EditCustomerPage verfyEditCustomerBtn() {
		editCustomer.click();
		return new EditCustomerPage();
	}
	
	public DeleteCustomerPage verfyDeleteCustomerBtn() {
		deleteCustomer.click();
		return new DeleteCustomerPage();
	}
	
}