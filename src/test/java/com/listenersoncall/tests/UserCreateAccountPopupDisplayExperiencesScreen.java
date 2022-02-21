package com.listenersoncall.tests;

import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserCreateNewAccountPage;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserExperiencesMenuPage;
import com.listenersoncall.pages.UserSignInPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.LogUtilities;

public class UserCreateAccountPopupDisplayExperiencesScreen extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserDashboardPage objUserDashboardPage;
	UserCreateNewAccountPage objUserCreateNewAccountPage;
	UserSignInPage objUserSignInPage;
	UserExperiencesMenuPage objUserExperiencesMenuPage;
		
	
	@Test(priority = 1)
	public void verifyDisplayingCreateAccountCanYouRelateNo() throws Exception {
			
			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
			objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
			
			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP*3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");
			
			
			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Experiences");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
			objUserExperiencesMenuPage.clickOnCanYouRelateNoBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
			objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
			objUserExperiencesMenuPage.clickOnCreateAccountBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserCreateNewAccountPage.verifyCreateAccountPageisDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Once Application Navigated to Create Account Page");
			objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
			objUserCreateNewAccountPage.clickOnendAccountCreationBtn();
			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyGuestText();
	}
	
	
	@Test(priority = 2)
	public void verifyDisplayingSigninInCanYouRelateNo() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
		objUserSignInPage = new UserSignInPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Experiences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
		objUserExperiencesMenuPage.clickOnCanYouRelateNoBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserExperiencesMenuPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 3)
	public void verifyDisplayingOfNotnowCanYouRelateNo() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Experiences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
		objUserExperiencesMenuPage.clickOnCanYouRelateNoBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserExperiencesMenuPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.verifyExperiencesPageTitle();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Navigated to Experiences Tab");
	}
	
	//Can You Relate-YES
	@Test(priority = 4)
	public void verifyDisplayingCreateAccountCanYouRelateYes() throws Exception {
			
			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
			objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
			
			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP*3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");
			
			
			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Experiences");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
			objUserExperiencesMenuPage.clickOnCanYouRelateYesBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
			objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
			objUserExperiencesMenuPage.clickOnCreateAccountBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserCreateNewAccountPage.verifyCreateAccountPageisDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Once Application Navigated to Create Account Page");
			objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
			objUserCreateNewAccountPage.clickOnendAccountCreationBtn();
			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyGuestText();
	}
	
	
	@Test(priority = 5)
	public void verifyDisplayingSigninInCanYouRelateYes() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
		objUserSignInPage = new UserSignInPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Experiences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
		objUserExperiencesMenuPage.clickOnCanYouRelateYesBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserExperiencesMenuPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 6)
	public void verifyDisplayingOfNotnowCanYouRelateYes() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserExperiencesMenuPage = new UserExperiencesMenuPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Experiences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.clickOnFirstRecommendedAudioBtn();
		objUserExperiencesMenuPage.clickOnCanYouRelateYesBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserExperiencesMenuPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.verifyExperiencesPageTitle();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Navigated to Experiences Tab");
	}
	
}
