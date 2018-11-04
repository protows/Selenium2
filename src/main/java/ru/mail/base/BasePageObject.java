package ru.mail.base;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
//import System.Collections.Generic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}
	
	protected void type(String text, By element) {
		find(element).sendKeys(text); 
	}
	
	protected void fillTextarea(String text, By element) {
		driver.switchTo().frame(0);
		find(element).sendKeys(text); 
		driver.switchTo().defaultContent();
	}
	
	
	protected void click(By element) {
		find(element).click(); 
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}
	
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				
			}
			attempts++;
		}
	}
	private void waitFor(ExpectedCondition<WebElement> expectedCondition, Integer integer) {
		if (integer != null)
			integer = integer;
		else
			integer = 30;
		WebDriverWait wait = new WebDriverWait(driver, integer);
		wait.until(expectedCondition);
	}
	
}
