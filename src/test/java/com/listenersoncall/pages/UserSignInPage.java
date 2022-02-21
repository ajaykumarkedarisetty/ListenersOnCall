package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class UserSignInPage {

	WebDriver driver;

	public By listenersLogo = By.xpath("//img[@alt='loc-logo']");
	public By userNameLabel = By.xpath("//label[text()='User Name']");
	public By userNameTextbox = By.xpath("//input[@name='userName']");
	public By passwordLabel = By.xpath("//label[text()='Password']");
	public By passwordTextbox = By.xpath("//input[@name='password']");
	public By loginBtn = By.xpath("//button[text()='Login']");
	public By forgotPasswordLink = By.xpath("//div[text()='Forgot Password']");
	
	public UserSignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUserNameLabelText(String expectedlabel) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, userNameLabel);
		String actualLabel = driver.findElement(userNameLabel).getText();
		assertEquals(actualLabel, expectedlabel);
		LogUtilities.extentLogPass("VERFYING USERNAME LABEL, ACTUAL LABEL=>"+actualLabel + " ,EXPECTED LABEL=>"+expectedlabel);
	}
	
	public void enterUserName(String username) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, userNameTextbox);
		driver.findElement(userNameTextbox).sendKeys(username);
		LogUtilities.extentLogPass("Value Entered In Email Textbox=>" + username);
	}
	
	public void verifyPasswordLabelText(String expectedlabel) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, passwordLabel);
		String actualLabel = driver.findElement(passwordLabel).getText();
		assertEquals(actualLabel, expectedlabel);
		LogUtilities.extentLogPass("VERFYING PASSWORD LABEL, ACTUAL LABEL=>"+actualLabel + " ,EXPECTED LABEL=>"+expectedlabel);
		
	}
	
	public void enterPassword(String password) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, passwordTextbox);
		driver.findElement(passwordTextbox).sendKeys(password);
		LogUtilities.extentLogPass("Value Entered In PASSWORD Textbox=>" + password);
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
		LogUtilities.extentLogPass("Clicked On LOGIN Button.");
	}
	
	public void clickOnForgotPasswordLink() {
		driver.findElement(forgotPasswordLink).click();
		LogUtilities.extentLogPass("Clicked On FORGOT PASSWORD Link.");
	}
	
	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickOnLoginBtn();
	}
	
	
}
