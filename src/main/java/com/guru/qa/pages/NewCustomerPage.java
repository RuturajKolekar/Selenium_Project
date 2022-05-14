package com.guru.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru.qa.base.TestBase;

public class NewCustomerPage extends TestBase {
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath = "//input[@value='m']")
	WebElement gender;
	
	@FindBy(xpath = "//input[@id='dob']")
	WebElement dob;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinCode;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement phoneNo;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit;
	
	
	@FindBy(xpath = "//p[@class='heading3']")
	WebElement pageHeaader;
	
	
	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public String verifyPageHeader(){
		return pageHeaader.getText();
	}
	
	public void validateRegisterForm(String NAME,String date,String add,String ct,String stat,String pin,String no,String mail,String psw) {
		name.sendKeys(NAME);
		gender.click();
		dob.sendKeys(date);
		address.sendKeys(add);
		city.sendKeys(ct);
		state.sendKeys(stat);
		pinCode.sendKeys(pin);
		phoneNo.sendKeys(no);
		email.sendKeys(mail);
		pass.sendKeys(psw);
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
