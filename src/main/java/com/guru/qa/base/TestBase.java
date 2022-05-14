package com.guru.qa.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.guru.qa.util.TestUtil;

import Util.extentReports.ExtentTestManager;
import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(Util.listeners.TestListener.class)

public class TestBase  {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
	public static ExtentReports extentreports;
	ExtentTestManager manger;
	
	
public WebDriver getDriver() {
		
		return driver;
	}

	
	
	public TestBase() {

		//String path = System.getProperty("user.dir");
		//System.out.println(path);
		prop = new Properties();

		try {
			ip = new FileInputStream("D:\\Java Programs\\EclipsPrograms\\Guru99Test\\src\\main\\java\\com\\guru\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeSuite
	public void intializeExtentReport() {
		extentreports=new ExtentReports();
		ExtentSparkReporter sparkreport=new ExtentSparkReporter("D:\\Java Programs\\EclipsPrograms\\Guru99Test"
				+ "\\ExtentReport\\report.html");
		extentreports.attachReporter(sparkreport);
		
	}
	
	
	public void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}	
	
//		WebDriverListener listener = new com.guru.qa.util.WebdriverListenerDemo();
//		WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);
//		driver=decorated;
		
		 
		
		

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeOuts.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void tearDown() {
		extentreports.flush();
	}
	

}
