package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = ("user_email"))
	private WebElement email;

	@FindBy(id = ("user_password"))
	private WebElement password;

	@FindBy(name = ("commit"))
	private WebElement button;

	public WebElement emailID() {
		return email;
	}

	public WebElement password() {
		return password;
	}

	public WebElement LogInbutton() {
		return button;
	}

}
