package com.test.automation.FrameworkPractice.CustomListeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;


public class WebEventListener implements WebDriverEventListener{
	
	public static final Logger log = Logger.getLogger(WebEventListener.class.getName());

	public void afterAlertAccept(WebDriver arg0) {
		//writeLog("alert accepted");
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {		// TODO Auto-generated method stub
		//writeLog("value changed");
	}

	public void afterClickOn(WebElement element, WebDriver arg1) {
		//writeLog("clicked on "+element.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver arg2) {
		//writeLog("found element"+by.toString());
	}

	public void afterNavigateBack(WebDriver arg0) {
		
	}

	public void afterNavigateForward(WebDriver arg0) {
		
	}

	public void afterNavigateRefresh(WebDriver arg0) {
		//writeLog("page refreshed");
	}

	public void afterNavigateTo(String url, WebDriver arg1) {
		//writeLog("navigated to "+url);
	}

	public void afterScript(String arg0, WebDriver arg1) {
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		
	}

	public void beforeClickOn(WebElement element, WebDriver arg1) {
		writeLog("trying to click on "+element.toString());
	}

	public void beforeFindBy(By by, WebElement arg1, WebDriver arg2) {
		writeLog("trying to find element "+by.toString());
	}

	public void beforeNavigateBack(WebDriver arg0) {
		writeLog("navigating back");
	}

	public void beforeNavigateForward(WebDriver arg0) {
		writeLog("navigating forward");
	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		writeLog("trying to refresh page");
	}

	public void beforeNavigateTo(String url, WebDriver arg1) {
		writeLog("navigating to: "+url);
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		writeLog("executing script");
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		writeLog("exception occurred");
	}
	
	public void writeLog(String data) {
		//this is log4j logs
		//this will print log in the console and automation.out file
		log.info(data);
		
		//this will log in the emailable-report.html
		Reporter.log(data);
	}


}
