package com.test.automation.FrameworkPractice.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="lst-ib")
	WebElement txtfld_Search;
	
	@FindBy(name="btnK")
	WebElement btn_GoogleSearch;
	
	@FindBy(name="btnI")
	WebElement btn_FeelingLucky;
	
	@FindBy(id="gb_70")
	WebElement btn_Signin;
	
	public void searchQueryWithGoogleSearch(String query) {
		//log.info("clearing text field");
		txtfld_Search.clear();
		
		//log.info("entering query in text field: "+query);
		txtfld_Search.sendKeys(query);
		
		//log.info("clicking on Google Search button");
		btn_GoogleSearch.click();
	}
	
	public void searchQueryWithFeelingLucky(String query) {
		//log.info("clearing text field");
		txtfld_Search.clear();
		
		//log.info("entering query in text field: "+query);
		txtfld_Search.sendKeys(query);
		
		//log.info("clicking on Feeling Lucky button");
		btn_FeelingLucky.click();
	}


}
