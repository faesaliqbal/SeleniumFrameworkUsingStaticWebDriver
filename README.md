# SeleniumFrameworkUsingStaticWebDriver
Selenium Framework using Page factory approach

Demo site: https://www.google.com/

Project Type: Maven

Page Object Model: Page Factory

Execution Engine: TestNG with testng.xml file

Data Source: config.properties file to read data like url, username and password

Logging Mechanism: log4j for logging into console as well as file

Custom Listeners:

  Retry Listener: to retry a failed test case
  
  ITestListener: to listen to the testcases and perform some logging when a testcase gets passed/failed/skipped and things like that
  
  WebDriverEventListener: to listen to different events e.g. findElement, click etc and perform some logging

Capture screenshots when a testcase gets failed

attach screenshots(failed test cases) with TestNG emailable report

Static WebDriver shared by almost each and every class
