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

public class UserCreateAccountPopupDisplayFunctionality extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserDashboardPage objUserDashboardPage;
	UserListenersMenuPage objUserListenersMenuPage;
	UserCreateNewAccountPage objUserCreateNewAccountPage;
	UserSignInPage objUserSignInPage;
	UserExperiencesMenuPage objUserExperiencesMenuPage;
		
	@Test(priority = 1)
	public void verifyDisplayingAndNavigationOfCreateAccount() throws Exception {
			
			objUserWelcomePage = new UserWelcomePage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserListenersMenuPage = new UserListenersMenuPage(driver);
			objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
			
			objUserWelcomePage.clickOnExploreListeners();

			Thread.sleep(Constants.SHORT_SLEEP*3);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			objUserDashboardPage.verifyGuestText();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");
			
			
			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnMenu("Listeners");
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserListenersMenuPage.clickOnMyListenersTab();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserListenersMenuPage.verifyCreateAccountPopupTitleTxt();
			objUserListenersMenuPage.verifyCreateAccountPopupBodyTxt();
			objUserListenersMenuPage.clickOnCreateAccountBtn();
			Thread.sleep(Constants.SHORT_SLEEP);
			objUserCreateNewAccountPage.verifyCreateAccountPageisDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver,
					"Captured the screenshot, Once Application Navigated to Create Account Page");
			objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
			objUserCreateNewAccountPage.clickOnendAccountCreationBtn();
			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyGuestText();
	}
	
	@Test(priority =2)
	public void verifyDisplayingAndNavigationOfSignIn() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserListenersMenuPage = new UserListenersMenuPage(driver);
		objUserSignInPage = new UserSignInPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Listeners");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserListenersMenuPage.clickOnMyListenersTab();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserListenersMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserListenersMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserListenersMenuPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 3)
	public void verifyDisplayingAndNavigationOfNotnow() throws Exception {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		objUserListenersMenuPage = new UserListenersMenuPage(driver);
		
		//TestCase Starting
		objUserWelcomePage.clickOnExploreListeners();

		Thread.sleep(Constants.SHORT_SLEEP * 3);
		objUserDashboardPage.verifyToolbarIsDisplayed();
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");

		objUserDashboardPage.clickOnSideMenuBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserDashboardPage.clickOnMenu("Listeners");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserListenersMenuPage.clickOnMyListenersTab();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserListenersMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserListenersMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserListenersMenuPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserListenersMenuPage.verifyListenersPageTitle();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Navigated to Listeners Tab");
	}
	
	@Test(priority = 4)
	public void verifyDisplayingAndNavigationOfCreateAccountExperience() throws Exception {
			
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
			objUserExperiencesMenuPage.clickOnFavoritesTab();
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
	public void verifyDisplayingSigninInExperiencesTab() throws Exception {

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
		objUserExperiencesMenuPage.clickOnFavoritesTab();
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
	public void verifyDisplayingOfNotnowInExperiencesTab() throws Exception {

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
		objUserExperiencesMenuPage.clickOnFavoritesTab();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserExperiencesMenuPage.verifyCreateAccountPopupTitleTxt();
		objUserExperiencesMenuPage.verifyCreateAccountPopupBodyTxt();
		objUserExperiencesMenuPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserExperiencesMenuPage.verifyExperiencesPageTitle();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Navigated to Experiences Tab");
	}
	
	
	@Test(priority = 7)
	public void verifyDisplayingAndNavigationOfCreateAccountLibrary() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Library");
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
	
	
	@Test(priority = 8)
	public void verifyDisplayingSigninInLibraryTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Library");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 9)
	public void verifyDisplayingOfNotnowInLibraryTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Library");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Nagigated back to Dashboard Tab");
	}
	
	//*************************My Profile Tab****************************//
	
	@Test(priority = 10)
	public void verifyDisplayingAndNavigationOfCreateAccountMyProfileTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Profile");
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
	
	
	@Test(priority = 11)
	public void verifyDisplayingSigninInMyProfileTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Profile");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 12)
	public void verifyDisplayingOfNotnowInMyProfileTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Profile");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Nagigated back to Dashboard Tab");
	}
	
	//*****************************MY PREFERENCES*****************************//
	@Test(priority = 13)
	public void verifyDisplayingAndNavigationOfCreateAccountMyPreferencesTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Preferences");
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
	
	
	@Test(priority = 14)
	public void verifyDisplayingSigninInMyPreferencesTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Preferences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 15)
	public void verifyDisplayingOfNotnowInMyPreferencesTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("My Preferences");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Nagigated back to Dashboard Tab");
	}
	
	//**********************************Payment********************************//
	@Test(priority = 16)
	public void verifyDisplayingAndNavigationOfCreateAccountPaymentTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Payment");
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
	
	
	@Test(priority = 17)
	public void verifyDisplayingSigninInPaymentTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Payment");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountSignInBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserSignInPage.verifyUserNameLabelText("User Name");
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Once Application Navigated to SignIn Page");
	}
	
	@Test(priority = 18)
	public void verifyDisplayingOfNotnowInPaymentTab() throws Exception {

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
		objUserDashboardPage.clickOnMenu("Payment");
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyCreateAccountPopupTitleTxt();
		objUserDashboardPage.verifyCreateAccountPopupBodyTxt();
		objUserDashboardPage.clickOnCreateAccountNotnowBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyGuestText();
		LogUtilities.extentLogInfoWithScreenShot(driver,
				"Captured the screenshot, Application Nagigated back to Dashboard Tab");
	}
	
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
			ScrollUtilities.scrollDown(driver);
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
			ScrollUtilities.scrollDown(driver);
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
