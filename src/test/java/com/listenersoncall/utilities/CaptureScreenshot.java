package com.listenersoncall.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenshot {

	public static JavascriptExecutor js = null;

	public static void getScreenshot(WebDriver driver, String fileName) throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/" + fileName + ".png"));
	}

	public static void getScreenshotInPath(WebDriver driver, String path, String fileName) throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path + "//" + fileName + ".png"));
	}

	public static String getScreenshotInBase64Format(WebDriver driver) {
		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
	}

}
