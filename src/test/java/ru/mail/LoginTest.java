package ru.mail;

import org.testng.annotations.Test;
import ru.mail.pages.LoginPage;
import ru.mail.base.BaseTest;
import ru.mail.pages.ProfilePage;
import ru.mail.pages.ComposeEmailPage;

public class LoginTest extends BaseTest{
	@Test
	  public void positiveLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openLoginPage();
		loginPage.fillUpEmailAndPassword("####", "#####");
		loginPage.pushSignButton();
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.waitForProfilePageToLoad();
		profilePage.pushcomposeEmailButton();
		ComposeEmailPage composeEmailPage = new ComposeEmailPage(driver);
		composeEmailPage.waitForProfilePageToLoad();
		composeEmailPage.fillUpEmailReceiverAndTextArea("prims_test@mail.ru", "Hello, this is a test message");
		composeEmailPage.pushSignButton();
		
	}

}
