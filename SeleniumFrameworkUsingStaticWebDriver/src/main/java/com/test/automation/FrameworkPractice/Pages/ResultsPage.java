package com.test.automation.FrameworkPractice.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResultsPage {
	public static final Logger log = Logger.getLogger(ResultsPage.class.getName());
	
	WebDriver driver;
	
	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="gb_70")
	WebElement btn_Signin;
	
	@FindBy(id="abar_button_opt")
	WebElement btn_Settings;
	
	@FindBy(id="hdtb-tls")
	WebElement btn_Tools;

	public void navigateToSignin() {
		//log.info("clicking on Sign in button");
		btn_Signin.click();
	}
	
	public void navigateToSettings() {
		//log.info("clicking on settings button");
		btn_Settings.click();
	}
	
	public void navigateToTools() {
		//log.info("clicking on tools button");
		btn_Tools.click();
	}


}
