package ru.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.mail.base.BasePageObject;
import ru.mail.pages.ComposeEmailPage;

public class ProfilePage extends BasePageObject<ProfilePage>{
	private By composeEmailButton = By.cssSelector("a.b-toolbar__btn > span:nth-child(2)");
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForProfilePageToLoad() {
		waitForVisibilityOf(composeEmailButton);
	}
	
	public ComposeEmailPage pushcomposeEmailButton() {
		click(composeEmailButton);
		return new ComposeEmailPage(driver);
	}

}
