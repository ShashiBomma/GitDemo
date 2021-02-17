package Academy.E2EFrameworkProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjectClasses.LandingPage;
import PageObjectClasses.LoginPage;

public class HomePage extends Base {
	
	private static Logger log = LogManager.getLogger(HomePage.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Browser is opened");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		driver.get(props.getProperty("url"));
		log.info("Home page is opened");
		LandingPage lp = new LandingPage(driver);
		lp.loginButton().click();
		log.info("Login button is clicked");
		LoginPage hp = new LoginPage(driver);
		hp.emailID().sendKeys(username);
		log.debug("Username is entered");
		hp.password().sendKeys(password);
		log.debug("Password is entered");
		hp.LogInbutton().click();
		log.debug("Button is clicked");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "Unauthorizeduser";
		data[0][1] = "123456";

		data[1][0] = "Authorizeduser";
		data[1][1] = "654321";

		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
