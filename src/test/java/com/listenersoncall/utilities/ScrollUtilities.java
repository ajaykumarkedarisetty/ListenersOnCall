package com.listenersoncall.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtilities {

	public static JavascriptExecutor js;

		public static void defaultResol(WebDriver driver) {
		// To set browser to default zoom level 100%
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='100%'");
	}

	public static void scrollDown(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollUp(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)");
	}

	public static void zoomOut(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}

	public static void scrollDownElement(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 100)");
	}

	public static void scrollUpElement(WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(500, 0)");
	}

	public static void scrollDownWithParam(WebDriver driver, int param) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0," + param + ")");
	}

	public static void scrollLeftWithParam(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
	}

}
