package com.test.automation.FrameworkPractice.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.test.automation.FrameworkPractice.CustomListeners.WebEventListener;




public class TestBase {
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver dr;
	public EventFiringWebDriver driver;
	public WebEventListener eventListener;
	
	FileInputStream fis;
	Properties prop;
	
	public void loadConfigPropertiesFile() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
		prop = new Properties();
		prop.load(fis);
	}


	
	public void init() throws IOException {
		loadConfigPropertiesFile();
		selectBrowser(prop.getProperty("browser"));
		getUrl(prop.getProperty("url"));
		String log4jConfPath = System.getProperty("user.dir")+"/log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

	
	
	public void selectBrowser(String browser) {
		String driversPath = System.getProperty("user.dir")+"/drivers/";
		
		if(browser.equalsIgnoreCase("chrome")) {
			//For Mac
			System.setProperty("webdriver.chrome.driver", driversPath+"chromedriver");
			
			//writeLog("launching "+browser+ " browser");
			dr = new ChromeDriver();
			driver = new EventFiringWebDriver(dr);
			eventListener = new WebEventListener();
			driver.register(eventListener);
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			//For Mac
			System.setProperty("webdriver.firefox.marion", driversPath+"geckodriver");
			//writeLog("launching "+browser+ "browser");
			//driver = new FirefoxDriver();
		}
	}
	
	public void getUrl(String url) {
		//writeLog("launching url: "+url);
		driver.get(url);
		
		driver.navigate().refresh();
	
		//writeLog("maximizing browser window");
		driver.manage().window().maximize();
		
		//writeLog("setting implicit wait to 60 seconds");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void writeLog(String data) {
		//this is log4j logs
		//this will print log in the console and automation.out file
		log.info(data);
		
		//this will log in the emailable-report.html
		Reporter.log(data);
	}




}
