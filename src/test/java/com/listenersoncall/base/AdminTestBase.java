package com.listenersoncall.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.PropertiesOperation;

public class AdminTestBase {

	public static WebDriver driver;
	BrowserFactory browserfactory = new BrowserFactory();

	@BeforeMethod
	public void launchApplication() {

		String browser = PropertiesOperation.getPropertyValueByKey("browser").toLowerCase();
		String adminurl = PropertiesOperation.getPropertyValueByKey("adminurl");

		driver = browserfactory.createBrowserInstance(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.AVG_IMPLICIT, TimeUnit.SECONDS);
		driver.get(adminurl);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(
						"Test Case Status is Passed=>" + result.getMethod().getMethodName(), ExtentColor.GREEN));
			} else if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
				ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64).build());
			} else if (result.getStatus() == ITestResult.SKIP) {
				ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper
						.createLabel("Test Case Skipped=>" + result.getMethod().getMethodName(), ExtentColor.YELLOW));
			}
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
