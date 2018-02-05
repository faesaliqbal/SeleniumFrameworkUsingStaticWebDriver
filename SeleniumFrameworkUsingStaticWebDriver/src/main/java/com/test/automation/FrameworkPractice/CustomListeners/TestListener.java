package com.test.automation.FrameworkPractice.CustomListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.FrameworkPractice.testbase.TestBase;

public class TestListener extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		writeLog("==================Testcase started running: " +result.getMethod().getMethodName()+"==================");
	}

	public void onTestSuccess(ITestResult result) {
		writeLog("=========Testcase succeeded: " +result.getMethod().getMethodName()+"=========/n");
	}

	public void onTestFailure(ITestResult result) {
		
		//if test case result is not successful
		if(!result.isSuccess()) { 
			
			//this will give us the location till our project
			String userDirectory = System.getProperty("user.dir");
			
			//this is the path to the screenshots folder after the project
			String customeLocation = "/src/main/java/com/test/automation/FrameworkPractice/screenshots/";
			
			//with what name i want my screenshot
			String failureImageFileName = userDirectory+customeLocation+new SimpleDateFormat("MM-dd-yyyy-HH-ss").format(new GregorianCalendar().getTime())+"_"+result.getMethod().getMethodName() + ".png";
			
			//this will capture the screenshot in terms of file
			File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
			writeLog("screenshot captured:");
			
			try {
				//copy this screenshot to the destination
				FileUtils.copyFile(scrFile, new File(failureImageFileName));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			//attach this screenshot with testng report in form of link
			writeLog("<a href=\"" + failureImageFileName + "\"><img src=\"file:///" + failureImageFileName + "\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
			Reporter.setCurrentTestResult(null);
			//writeLog(result.getName()+ "--Test method failed\n");
			writeLog("=========Testcase failed: " +result.getMethod().getMethodName()+"=========/n");
		}

		
	}

	public void onTestSkipped(ITestResult result) {
		writeLog("=========Testcase skipped: " +result.getMethod().getMethodName()+"=========/n");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		writeLog("===========================Test started: "+context.getName()+"===========================");
	}

	public void onFinish(ITestContext context) {
		writeLog("===========================Test fininshed: "+context.getName()+"===========================");
	}
	



}
