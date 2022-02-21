package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.ActionsClass;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class AdminSignInPage {

	WebDriver driver;
	public By listenetsLogoLocator = By.xpath("//img[@alt='login']");
	public By userNameLabelLocator = By.xpath("//label[text()='Username']");
	public By passwordLabelLocator = By.xpath("//label[text()='Password']");
	public By userNameTextboxLocator = By.xpath("//input[@type='text']");
	public By passwordTextboxLocator = By.xpath("//input[@type='password']");
	public By submitBtnLocator = By.xpath("//button[@type='submit']");

	public AdminSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyListenersLogoIsDisplayed() {
		boolean actualFlag = ActionsClass.verifyImage(driver, driver.findElement(listenetsLogoLocator));
		 assertTrue(actualFlag, "Listeners Logo Is Not Displayed");
		 LogUtilities.extentLogPass("Listeners Logo Is Displayed");
	}
	
	public void verifyUserNameText() {
		String getusernametext = driver.findElement(userNameLabelLocator).getText();
		assertEquals(getusernametext, "Username");
		 LogUtilities.extentLogPass("Verified 'USERNAME' Label, Actual Label=>"+getusernametext);
	}
	
	public void verifyPasswordText() {
		String getpasswordtext = driver.findElement(passwordLabelLocator).getText();
		assertEquals(getpasswordtext, "Password");
		LogUtilities.extentLogPass("Verified 'PASSWORD' Label, Actual Label=>"+getpasswordtext);
	}

	public void enterUserName(String username) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, userNameTextboxLocator);
		driver.findElement(userNameTextboxLocator).sendKeys(username);
		LogUtilities.extentLogPass("Text Entered In UserName Field Is=>"+username);
	}
	
	public void enterPassword(String password) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, passwordTextboxLocator);
		driver.findElement(passwordTextboxLocator).sendKeys(password);
		LogUtilities.extentLogPass("Text Entered In Password Field Is=>"+password);
	}
	
	public void clickOnSubmit() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, submitBtnLocator);
		driver.findElement(submitBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On SUBMIT Button.");
	}
	
	public void adminLogin(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnSubmit();
	}
	
}
