package Academy.E2EFrameworkProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectClasses.LandingPage;

public class LinksValidation extends Base {

	WebDriver driver;
	private static Logger log = LogManager.getLogger(LinksValidation.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeBrowser();
		log.info("Browser is opened");
		driver.get(props.getProperty("url"));
		log.info("Page is opened");
	}

	@Test
	public void getText() throws IOException {
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.linkDisplayed().isDisplayed());
		log.info("All the links on page is displayed");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
