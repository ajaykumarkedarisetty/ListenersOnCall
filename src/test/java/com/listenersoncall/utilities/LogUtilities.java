package com.listenersoncall.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.listenersoncall.base.ExtentTestManager;

public class LogUtilities {

	public static void extentLogInfo(String message) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	public static void extentLogError(String message) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(Status.FAIL, message);
	}

	public static void extentLogPass(String message) {
		Reporter.log(message, true);
		ExtentTestManager.getTest().log(Status.PASS, message);
	}
	
	
	public static void extentLogInfoWithScreenShot(WebDriver driver, String logmessage) {
		Reporter.log(logmessage, true);
		ExtentTestManager.getTest().log(Status.INFO, logmessage, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshotInBase64Format(driver)).build());
	}
	
	public static void extentLogFailWithScreenShot(WebDriver driver, String logmessage) {
		Reporter.log(logmessage, true);
		ExtentTestManager.getTest().log(Status.FAIL, logmessage, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshotInBase64Format(driver)).build());
		
	}
	
	public static void extentLogPassWithScreenShot(WebDriver driver, String logmessage) {
		Reporter.log(logmessage, true);
		ExtentTestManager.getTest().log(Status.PASS,logmessage, MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenshot.getScreenshotInBase64Format(driver)).build());
	}

}
