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

public class UserExperiencesMenuPage {

	WebDriver driver;

	By experiencesPageTitle = By.xpath("//div[text()='Experiences']");
	By recommendedTab = By.xpath("//button[text()='RECOMMENDED']");
	By favoritiesTab = By.xpath("//button[text()='FAVORITES']");
	By createAccountPopupTitle = By.xpath("//h3[text()='Create your account first.']");
	By createAccountHelpText = By.xpath("//h3[contains(text(),'create your account in order to continue')]");
	By createAccountBtn = By.xpath("//button[text()='CREATE ACCOUNT']");
	By createAccountSignInBtn = By.xpath("//button[text()='SIGN IN']");
	By createAccountNotNowBtn = By.xpath("//button[text()='NOT NOW']");
	By firstRecommendedAudioBtn = By.xpath("(//div[@role='button'])[position()=1]//img[@alt='play-button']");
	By canYouRelateNoBtn = By.xpath("//button[text()='NO']");
	By canYouRelateYesBtn = By.xpath("//button[text()='YES']");
	
	public UserExperiencesMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyExperiencesPageTitle() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, experiencesPageTitle);
		boolean flag = driver.findElement(experiencesPageTitle).isDisplayed();
		assertTrue(flag, "Experiences Page Title is not displayed");
		LogUtilities.extentLogPass("Verified the Experiences Page is displaying");
	}
	
	public String validateListenersPageTitle() {
		String actualTitle = driver.findElement(experiencesPageTitle).getText();
		return actualTitle;
	}

	public void clickOnRecommendedTab() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, recommendedTab);
		driver.findElement(recommendedTab).click();
		LogUtilities.extentLogPass("Clicked On 'RECOMMENDED' Tab");
	}
	
	public void clickOnFavoritesTab() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, favoritiesTab);
		driver.findElement(favoritiesTab).click();
		LogUtilities.extentLogPass("Clicked On 'FAVORITIES' Tab");
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
	
	
	public void clickOnFirstRecommendedAudioBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, firstRecommendedAudioBtn);
		driver.findElement(firstRecommendedAudioBtn).click();
		LogUtilities.extentLogPass("Clicked On 'PLAY' Button");
	}
	
	public void clickOnCanYouRelateNoBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, canYouRelateNoBtn);
		driver.findElement(canYouRelateNoBtn).click();
		LogUtilities.extentLogPass("Clicked On 'Can You Relate No' Button");
	}
	
	public void clickOnCanYouRelateYesBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, canYouRelateYesBtn);
		driver.findElement(canYouRelateYesBtn).click();
		LogUtilities.extentLogPass("Clicked On 'Can You Relate Yes' Button");
	}
	
}
