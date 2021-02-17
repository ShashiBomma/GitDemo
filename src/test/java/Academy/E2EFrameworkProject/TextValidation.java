package Academy.E2EFrameworkProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectClasses.LandingPage;

public class TextValidation extends Base {
	private static Logger log = LogManager.getLogger(TextValidation.class.getName());

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
		Assert.assertEquals(lp.textFound().getText(), "FEATURED COURSES");
		log.info("Test Validation is successful");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
