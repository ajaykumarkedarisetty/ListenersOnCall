package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class UserListenersMenuPage {

	WebDriver driver;

	By listenersPageTitle = By.xpath("//div[text()='Listeners']");
	By listenersTab = By.xpath("//button[text()='LISTENERS']");
	By myListenersTab = By.xpath("//button[text()='MY LISTENERS']");
	By listenersNamesList = By.xpath("//div[@data-cy-listener-tile='true']//h6[contains(@class,'text-dark-blue')]");
	By createAccountPopupTitle = By.xpath("//h3[text()='Create your account first.']");
	By createAccountHelpText = By.xpath("//h3[contains(text(),'create your account in order to continue')]");
	By createAccountBtn = By.xpath("//button[text()='CREATE ACCOUNT']");
	By createAccountSignInBtn = By.xpath("//button[text()='SIGN IN']");
	By createAccountNotNowBtn = By.xpath("//button[text()='NOT NOW']");
	
	public UserListenersMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyListenersPageTitle() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, listenersPageTitle);
		boolean flag = driver.findElement(listenersNamesList).isDisplayed();
		assertTrue(flag, "Listeners Page Title is not displayed");
		LogUtilities.extentLogPass("Verified the Listeners Page is displaying");
	}
	
	public String validateListenersPageTitle() {
		String actualTitle = driver.findElement(listenersPageTitle).getText();
		return actualTitle;
	}

	public List<WebElement> getAllListenersNamesList() {
		return driver.findElements(listenersNamesList);
	}
	
	public void clickOnMyListenersTab() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, myListenersTab);
		driver.findElement(myListenersTab).click();
		LogUtilities.extentLogPass("Clicked On My Listeners Tab");
	}

	public void verifyCreateAccountPopupTitleTxt() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountPopupTitle);
		String createYourAct = driver.findElement(createAccountPopupTitle).getText();
		assertEquals(createYourAct, "Create your account first.");
		LogUtilities.extentLogPass("Verfying 'Create your account first.' Text, ACTUAL TEXT=>"+createYourAct);
	}
	
	public void verifyCreateAccountPopupBodyTxt() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountHelpText);
		String createYourActHelp = driver.findElement(createAccountHelpText).getText();
		assertEquals(createYourActHelp, "You’ll need to create your account in order to continue. It just takes a minute!");
		LogUtilities.extentLogPass("Verfying 'CREATE ACCOUNT BODY TEXT' Text, ACTUAL TEXT=>"+createYourActHelp);
	}
	
	public void clickOnCreateAccountBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountBtn);
		driver.findElement(createAccountBtn).click();
		LogUtilities.extentLogPass("Clicked On Create Account Button");
	}
	
	public void clickOnCreateAccountSignInBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountSignInBtn);
		driver.findElement(createAccountSignInBtn).click();
		LogUtilities.extentLogPass("Clicked On 'SIGN IN' Button");
	}
	
	public void clickOnCreateAccountNotnowBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountNotNowBtn);
		driver.findElement(createAccountNotNowBtn).click();
		LogUtilities.extentLogPass("Clicked On 'NOT NOW' Button");
	}
	
}
