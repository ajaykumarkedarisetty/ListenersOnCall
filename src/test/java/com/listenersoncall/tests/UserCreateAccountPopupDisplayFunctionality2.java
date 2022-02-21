package com.listenersoncall.tests;

import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserCreateNewAccountPage;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserExperiencesMenuPage;
import com.listenersoncall.pages.UserListenersMenuPage;
import com.listenersoncall.pages.UserSignInPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.ScrollUtilities;

public class UserCreateAccountPopupDisplayFunctionality2 extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserDashboardPage objUserDashboardPage;
	UserListenersMenuPage objUserListenersMenuPage;
	UserCreateNewAccountPage objUserCreateNewAccountPage;
	UserSignInPage objUserSignInPage;
	UserExperiencesMenuPage objUserExperiencesMenuPage;
		
	
	//***********************SUPPORT TAB****************************//
		@Test(priority = 19)
		public void verifyDisplayingAndNavigationOfCreateAccountSupportTab() throws Exception {

			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);

			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP * 3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			ScrollUtilities.scrollDown(driver);
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Support");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
			objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
			objUserDashboardPage.clickOnCreateAccountBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserCreateNewAccountPage.verifyCreateAccountPageisDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Once Application Navigated to Create Account Page");
			objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
			objUserCreateNewAccountPage.clickOnendAccountCreationBtn();
			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyGuestText();
		}
		
		
		@Test(priority = 20)
		public void verifyDisplayingSigninInSupportTab() throws Exception {

			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserSignInPage = new UserSignInPage(driver);
			
			//TestCase Starting
			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP * 3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Support");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
			objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
			objUserDashboardPage.clickOnCreateAccountSignInBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserSignInPage.verifyUserNameLabelText("User Name");
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Once Application Navigated to SignIn Page");
		}
		
		@Test(priority = 21)
		public void verifyDisplayingOfNotnowInSupportTab() throws Exception {

			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			
			//TestCase Starting
			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP * 3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Support");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
			objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
			objUserDashboardPage.clickOnCreateAccountNotnowBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Application Nagigated back to Dashboard Tab");
		}
	
}
