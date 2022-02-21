package com.listenersoncall.tests;

import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserSignInPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.LogUtilities;

public class UserLoginTest extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserSignInPage objUserSignInPage;
	UserDashboardPage objUserDashboardPage;
	
	@Test()
	public void verifyLoginScreenUI() {
		try {
			objUserWelcomePage = new UserWelcomePage(driver);
			objUserSignInPage = new UserSignInPage(driver);

			objUserWelcomePage.clickOnSignIn();
			objUserSignInPage.verifyUserNameLabelText("User Name");
			objUserSignInPage.verifyPasswordLabelText("Password");
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED LOGIN PAGE SCREENSHOT");

		} catch (Exception e) {
			e.printStackTrace();
		} catch (AssertionError ae) {
			ae.printStackTrace();
		}
	}
	
	@Test
	public void verifyValidLoginFunctionality() throws Exception {
			
			String username = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
					"SignInTestData", "SignInValidDetails", 2);
			String password = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
					"SignInTestData", "SignInValidDetails", 3);

			objUserWelcomePage = new UserWelcomePage(driver);
			objUserSignInPage = new UserSignInPage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);

			objUserWelcomePage.clickOnSignIn();
			objUserSignInPage.enterUserName(username);
			objUserSignInPage.enterPassword(password);
			objUserSignInPage.clickOnLoginBtn();

			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");
	}
}
