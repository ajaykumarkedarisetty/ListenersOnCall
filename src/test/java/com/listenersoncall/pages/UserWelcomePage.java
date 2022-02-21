package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.listenersoncall.utilities.LogUtilities;

public class UserWelcomePage {
	
	WebDriver driver;
	
	By exploreListenersBtn = By.xpath("//button[text()='Explore Listeners']");
	By haveGroupIdbtn = By.xpath("//button[text()='I have a Group ID']");
	By createAccountBtn = By.xpath("//button[text()='Create Free Account']");
	By signInBtn = By.xpath("//button[text()='Sign In']");

	public UserWelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void validatePageTitle(String expectedTitle) {
		String actualPageTitle = driver.getTitle();
		assertEquals(actualPageTitle, expectedTitle);
	}

	public void clickOnCreateAccount() {
		driver.findElement(createAccountBtn).click();
		LogUtilities.extentLogPass("CLICK ON CREATE ACCOUNT BUTTON, APPLICATION NAVIGATED TO CREATE ACCOUNT SCREEN.");
	}
	
	public void clickOnExploreListeners() {
		driver.findElement(exploreListenersBtn).click();
		LogUtilities.extentLogPass("CLICK ON EXPLORE LISTENERS BUTTON, APPLICATION NAVIGATED TO DASHBOARD SCREEN.");
	}
	
	public void clickOnSignIn() {
		driver.findElement(signInBtn).click();
		LogUtilities.extentLogPass("CLICK ON SIGNIN BUTTON, APPLICATION NAVIGATED TO SIGNIN SCREEN.");
	}
	
	public void clickOnHaveGroupId() {
		driver.findElement(haveGroupIdbtn);
		LogUtilities.extentLogPass("CLICK ON HAVE GROUP ID BUTTON, APPLICATION NAVIGATED HAVE GROUP ID SCREEN.");
	}

}
