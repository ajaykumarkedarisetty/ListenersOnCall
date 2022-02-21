package com.listenersoncall.tests;

import org.testng.annotations.Test;

import com.listenersoncall.base.AdminTestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.AdminDashboardPage;
import com.listenersoncall.pages.AdminSignInPage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class AdminLoginTest extends AdminTestBase {

	AdminSignInPage objAdminSignInPage;
	AdminDashboardPage objAdminDashboardPage;
	
	@Test
	public void verifyAdminLoginScreenUI() throws InterruptedException {
		objAdminSignInPage = new AdminSignInPage(driver);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objAdminSignInPage.verifyUserNameText();
		objAdminSignInPage.verifyPasswordText();
		objAdminSignInPage.verifyListenersLogoIsDisplayed();
	}
	
	@Test
	public void verifyAdminLoginFunctionality() throws Exception {

		String username = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, "SignInTestData",
				"AdminLoginDetails", 2);
		String password = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, "SignInTestData",
				"AdminLoginDetails", 3);
		objAdminSignInPage = new AdminSignInPage(driver);
		objAdminDashboardPage = new AdminDashboardPage(driver);
		
		objAdminSignInPage.adminLogin(username, password);
		Thread.sleep(Constants.AVG_SLEEP);
		LogUtilities.extentLogInfoWithScreenShot(driver, "DashBoard Screen");
		objAdminDashboardPage.clickOnLogOut();
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, objAdminSignInPage.userNameTextboxLocator);
	}

}
