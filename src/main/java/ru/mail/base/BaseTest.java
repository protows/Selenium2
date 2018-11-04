package ru.mail.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BaseTest {
	public WebDriver driver;
	
  @Parameters({ "browser" })
  @BeforeMethod
	public void methodSetUp(String browser) {
	System.out.println("Method set up");
	driver = BrowserFactory.getDriver(browser);
   }  
  
   @AfterMethod
	 public void methodTearDown() {
	  System.out.println("Method tear down");
	  driver.quit();
   }

}