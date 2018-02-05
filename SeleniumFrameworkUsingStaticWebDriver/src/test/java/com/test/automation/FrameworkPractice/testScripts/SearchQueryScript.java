package com.test.automation.FrameworkPractice.testScripts;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.automation.FrameworkPractice.Pages.HomePage;
import com.test.automation.FrameworkPractice.testbase.TestBase;


public class SearchQueryScript extends TestBase{
	
	public static final Logger log = Logger.getLogger(SearchQueryScript.class.getName());
	
	HomePage homePage;
	String query = "selenium";
	
	@BeforeMethod
	public void setUp() throws IOException {
		init();
	}
	
	@Test
	public void test_GoogleSearch() {
		try {
			homePage = new HomePage(driver);
			homePage.searchQueryWithGoogleSearch(query);
			
			String actualResult = driver.getTitle();
			String expectedResult = query+" - Google Search";
			
			Assert.assertEquals(actualResult, expectedResult);
		}
		catch(AssertionError e) {
			writeLog(e.fillInStackTrace().toString());
			Assert.fail();
		}
		catch (Exception e) {
			//e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(enabled=true)
	public void test_FeelingLuckySearch() {
		homePage = new HomePage(driver);
		homePage.searchQueryWithFeelingLucky(query);

		String actualResult = driver.getTitle();
		String expectedResult = "Selenium - Web Browser Automation";
		
		//log.info("asserting actual result: "+actualResult+" with expected result: "+expectedResult);
		Assert.assertEquals(actualResult, expectedResult);
	}

	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}


}
