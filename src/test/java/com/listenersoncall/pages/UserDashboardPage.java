package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class UserDashboardPage {

	
	WebDriver driver;
	
	public By nameToolBar = By.xpath("//div[@class='flex items-center relative w-full justify-center']");
	public By guestNameTxt = By.xpath("//h6[text()='Guest']");
	public By getStartedBtn = By.xpath("//button[text()='GET STARTED']");
	public By letsTalkAboutTxt = By.xpath("//div[@data-cy-header-label=\"Let's talk about...\"]//label[text()=\"Let's talk about...\"]");
	public By letsTalkAboutMoreTxt = By.xpath("//div[@data-cy-header-label=\"Let's talk about...\"]//label[text()='MORE']");
	public By suggestedListenersTxt = By.xpath("//div[@data-cy-header-label='Suggested Listeners']//label[text()='Suggested Listeners']");
	public By suggestedExploreTxt = By.xpath("//div[@data-cy-header-label='Suggested Listeners']//label[text()='EXPLORE']");
	public By myResourceTxt = By.xpath("//div[@data-cy-header-label='My Resources']//label[text()='My Resources']");
	public By myResourceMoreTxt = By.xpath("//div[@data-cy-header-label='My Resources']//label[text()='MORE']");
	public By myProgramTxt = By.xpath("//div[@data-cy-header-label='My Program']//label[text()='My Program']");
	public By myProgramVisitTxt = By.xpath("//div[@data-cy-header-label='My Program']//label[text()='VISIT']");
	public By letsTalkAboutList = By.xpath("//div[@data-cy-experiences-listeners-title='true']");
	
	public By suggestedListenersList = By.xpath("//div[@data-cy-listener-tile='true']");
	public By myResourcesList = By.xpath("//div[@data-cy-resource-card-title='true']");
	public By myProgramList = By.xpath("//div[@data-cy-client-graphic-card-title='true']");
	public By sideMenuBtn = By.xpath("//img[@alt='left-icon']");
	public By listenersMenuTab = By.xpath("//div[@data-cy-menu-title='Listeners']");
	
	
	//Create Account Popup
	public By createAccountPopupTitle = By.xpath("//h3[text()='Create your account first.']");
	public By createAccountHelpText = By.xpath("//h3[contains(text(),'create your account in order to continue')]");
	public By createAccountBtn = By.xpath("//button[text()='CREATE ACCOUNT']");
	public By createAccountSignInBtn = By.xpath("//button[text()='SIGN IN']");
	public By createAccountNotNowBtn = By.xpath("//button[text()='NOT NOW']");
	
	public UserDashboardPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyToolbarIsDisplayed() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, nameToolBar);
		boolean actualflag = driver.findElement(nameToolBar).isDisplayed();
		assertTrue(actualflag, "Tool Bar is not displayed");
	}
	
	public void verifyGuestText() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, guestNameTxt);
		String actualguestTxt = driver.findElement(guestNameTxt).getText();
		assertEquals(actualguestTxt, "Guest");
		LogUtilities.extentLogPass("Verfying 'Guest' Role In ToolBar, ACTUAL TEXT=>"+actualguestTxt);
	}
	
	
	public void verifyDashboardScreenIsDisplayed() {
		boolean actualFlag  = driver.findElement(sideMenuBtn).isDisplayed();
		Assert.assertTrue(actualFlag, "Dashboard Page is not displayed");
	}
	
	public void verifyLetsTalkAboutText() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, letsTalkAboutTxt);
		String letstalkabouttxt = driver.findElement(letsTalkAboutTxt).getText();
		assertEquals(letstalkabouttxt, "Let's talk about...");
		LogUtilities.extentLogPass("Verfying LET'S TALK ABOUT Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public void verifyLetsTalkAboutMoreTxt() {
		String actualText = driver.findElement(letsTalkAboutMoreTxt).getText();
		assertEquals(actualText, "MORE");
		LogUtilities.extentLogPass("Verfying LET'S TALK ABOUT-'MORE' Text, ACTUAL TEXT=>"+actualText);
	}
	
	public void verifySuggestedListenersTxt() {
		String letstalkabouttxt = driver.findElement(suggestedListenersTxt).getText();
		assertEquals(letstalkabouttxt, "Suggested Listeners");
		LogUtilities.extentLogPass("Verfying SUGGESTED LISTENERS Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public void verifySuggestedListenersExploreTxt() {
		String letstalkabouttxt = driver.findElement(suggestedExploreTxt).getText();
		assertEquals(letstalkabouttxt, "EXPLORE");
		LogUtilities.extentLogPass("Verfying SUGGESTED LISTENERS-'EXPLORE' Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public void verifyMyResourceTxt() {
		String letstalkabouttxt = driver.findElement(myResourceTxt).getText();
		assertEquals(letstalkabouttxt, "My Resources");
		LogUtilities.extentLogPass("Verfying MY RESOURCES Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public void verifyMyResourceMoreTxt() {
		String letstalkabouttxt = driver.findElement(myResourceMoreTxt).getText();
		assertEquals(letstalkabouttxt, "MORE");
		LogUtilities.extentLogPass("Verfying MY RESOURCES-'MORE' Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public void verifyMyProgramTxt() {
		String letstalkabouttxt = driver.findElement(myProgramTxt).getText();
		assertEquals(letstalkabouttxt, "My Program");
		LogUtilities.extentLogPass("Verfying MY PROGRAM TEXT, ACTUAL Text=>"+letstalkabouttxt);
	}
	
	public void verifyMyProgramVisitTxt() {
		String letstalkabouttxt = driver.findElement(myProgramVisitTxt).getText();
		assertEquals(letstalkabouttxt, "VISIT");
		LogUtilities.extentLogPass("Verfying MY PROGRAM-'VISIT' Text, ACTUAL TEXT=>"+letstalkabouttxt);
	}
	
	public List<WebElement> getAllLetsTalkAboutList() {
		return driver.findElements(letsTalkAboutList);
	}
	
	public List<WebElement> getAllSuggestedListenersList() {
		return driver.findElements(suggestedListenersList);
	}
	
	public List<WebElement> getAllMyResourcesList() {
		return driver.findElements(myResourcesList);
	}
	
	public List<WebElement> getAllMyProgramList() {
		return driver.findElements(myProgramList);
	}
	
	public void clickOnSideMenuBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, sideMenuBtn);
		driver.findElement(sideMenuBtn).click();
		LogUtilities.extentLogPass("Clicked On SideMenu Button");
	}
	
	public void verifySideMenuListElement(String menuName, String expectedName) {
		String actualName = driver.findElement(By.xpath("//div[@data-cy-menu-title='"+menuName+"']")).getText();
		assertEquals(actualName, expectedName);
		LogUtilities.extentLogPass("Verfying Following Side Menu Text, Actual Text==>"+actualName +" ,Expected Text==>"+expectedName);
	}
	
	public void clickOnListenersMenu() {
		driver.findElement(listenersMenuTab).getText();
		LogUtilities.extentLogPass("Clicked On LISTENERS Menu");
	}
	
	public void clickOnMenu(String title) throws InterruptedException {
		String menuXpath = "//div[@data-cy-menu-title='"+title+"']";
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		driver.findElement(By.xpath(menuXpath)).click();
		LogUtilities.extentLogPass("Clicked On '"+ title +"' Menu");
	}
	
	
	//Create Account Popup Functions
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