package ru.mail.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mail.base.BasePageObject;
import org.openqa.selenium.By;

public class LoginPage extends BasePageObject<LoginPage>{
	private static final String url = "https://account.mail.ru/login?";
	private By emailField = By.cssSelector(".c0144 > div:nth-child(1) > input:nth-child(1)");
	private By passwordField = By.xpath("//input[@type='password']");
	private By signButton = By.xpath("//button[@type='submit']");
	
	public LoginPage (WebDriver driver) {
		super(driver);
	}
	
	public void openLoginPage() {
		getPage(url);
	}
	
	public void fillUpEmailAndPassword(String email, String password) {
		type(email, emailField);
		type(password, passwordField);
	}
	public ProfilePage pushSignButton() {
		click(signButton);
		return new ProfilePage(driver);
	}
	
}
