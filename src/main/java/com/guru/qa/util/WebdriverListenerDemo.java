package com.guru.qa.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import static Util.logs.Log.Log;

public class WebdriverListenerDemo implements WebDriverListener{

	

	public void beforeClick(WebElement element) {
		System.out.println("Trying to click on: " + element.toString());

	}

	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		
	}

	public void afterGet(WebDriver driver, String url) {
		System.out.println("after getting url: "+url);
		//Log.info("after getting url: "+url);
	}
	public void beforeGet(WebDriver driver, String url) {
		System.out.println("before getting url: "+url);
	}

	public void afterGetTitle(WebDriver driver, String result) {
		System.out.println("This is the Tiltle: "+driver+"  "+result);
	}

	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Trying to find Element By : " + locator);
	}

	
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found Element By : " +locator);

	}

	public void afterQuit(WebDriver driver) {
		System.out.println("Driver is quit now: "+driver);
	}

	
	public void afterClick(WebElement element) {
		System.out.println("Clicked on: " + element.toString());

	}

	
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {

		System.out.println("Sending keys: " + (keysToSend) );

	}

	
	public void afterDeleteAllCookies(Options options) {
		
		System.out.println("Deleting all cookies: " + options);

	}

	
	public void afterFullscreen(Window window) {
		System.out.println("Maximising The Window: " + window);

	}

}
