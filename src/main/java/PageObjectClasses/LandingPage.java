package PageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//*[text()='Login']"))
	private WebElement login;

	@FindBy(xpath = ("//*[text()='Featured Courses']"))
	private WebElement text;

	@FindBy(xpath = ("//a[text()='Home']/../.."))
	private WebElement links;

	@FindBy(xpath = ("//*[text()='NO THANKS']"))
	private WebElement popup;

	public WebElement loginButton() {
		return login;
	}

	public WebElement textFound() {
		return text;
	}

	public WebElement linkDisplayed() {
		return links;
	}

	public WebElement popup() {
		return popup;
	}
}
