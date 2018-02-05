package com.test.automation.FrameworkPractice.testScripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.automation.FrameworkPractice.Pages.HomePage;
import com.test.automation.FrameworkPractice.Pages.ResultsPage;
import com.test.automation.FrameworkPractice.testbase.TestBase;


public class ResultsScript extends TestBase{
	public static final Logger log = Logger.getLogger(ResultsScript.class.getName());
	
	HomePage homePage;
	ResultsPage resultsPage;
	String query = "selenium";
	
	@BeforeMethod
	public void setUp() throws IOException {
		init();
	}
	
	@Test(enabled=true)
	public void test_Signin() {
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		
		homePage.searchQueryWithGoogleSearch(query);
		resultsPage.navigateToSignin();
		
		String actualResult = driver.getTitle();
		String expectedResult = "Sign in - Google Accounts";
		
		//log.info("asserting actual result: "+actualResult+" with expected result: "+expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(enabled=true)
	public void test_Setings() {
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		
		homePage.searchQueryWithGoogleSearch(query);
		resultsPage.navigateToSettings();
		
		String actualResult = driver.getTitle();
		String expectedResult = query+" - Google Search";
		
		//log.info("asserting actual result: "+actualResult+" with expected result: "+expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(enabled=true)
	public void test_Tools() {
		homePage = new HomePage(driver);
		resultsPage = new ResultsPage(driver);
		
		homePage.searchQueryWithGoogleSearch(query);
		resultsPage.navigateToTools();
		
		String actualResult = driver.getTitle();
		String expectedResult = query+" - Google Search";
		
		//log.info("asserting actual result: "+actualResult+" with expected result: "+expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}


	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}



}
