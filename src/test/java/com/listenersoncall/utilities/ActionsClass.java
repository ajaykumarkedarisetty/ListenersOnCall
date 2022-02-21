package com.listenersoncall.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsClass {
	
	
	public static Boolean verifyImage(WebDriver driver, WebElement element) {
		Boolean logo = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0",
				element);
		return logo;
	}

}
