package Academy.E2EFrameworkProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporter;

public class TestListners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent; 
	public void onTestStart(ITestResult result) {
		ExtentReports extent = ExtentReporter.getReportObject();
		test = extent.createTest(result.getMethod().getMethodName());

	}

	/*public void onTestSuccess(ITestResult result) {
		WebDriver driver = null;
		test.log(Status.PASS, "Pass aytu guru");
		String testMethodName = result.getMethod().getMethodName();
		try {
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
						.get(result.getInstance());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getScreenshotTest(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	public void onTestFailure(ITestResult result) {
		String testMethodName = result.getMethod().getMethodName();
		try {
			getScreenshotTest(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}