package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.mail.base.BasePageObject;

public class ComposeEmailPage extends BasePageObject<ComposeEmailPage>{
	private By sendButton = By.cssSelector("div.b-toolbar__item_:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
	private By toEmail = By.cssSelector("textarea.js-input:nth-child(6)");
	private By textField = By.xpath("//body[@id='tinymce']");
	  
	
	public ComposeEmailPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForProfilePageToLoad() {
		waitForVisibilityOf(sendButton);
	}
	
	public void fillUpEmailReceiverAndTextArea(String emailReceiver, String textArea) {
		type(emailReceiver, toEmail);
		fillTextarea(textArea ,textField);
		// new method for text area type(textArea, textField);
	}
	
	public void pushSignButton() {
		click(sendButton);
	}
	

}
