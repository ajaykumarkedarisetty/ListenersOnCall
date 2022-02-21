package com.listenersoncall.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserListenersMenuPage;
import com.listenersoncall.pages.UserSignInPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.ScrollUtilities;

public class UserListenersMenuTest extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserSignInPage objUserSignInPage;
	UserDashboardPage objUserDashboardPage;
	UserListenersMenuPage objUserListenersMenuPage;
	
	
	@Test
	public void verifyUserListnerMenuFunctionality() throws Exception {
			
			String username = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
					"SignInTestData", "SignInValidDetails", 2);
			String password = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
					"SignInTestData", "SignInValidDetails", 3);

			objUserWelcomePage = new UserWelcomePage(driver);
			objUserSignInPage = new UserSignInPage(driver);
			objUserDashboardPage = new UserDashboardPage(driver);
			objUserListenersMenuPage = new UserListenersMenuPage(driver);

			objUserWelcomePage.clickOnSignIn();
			objUserSignInPage.enterUserName(username);
			objUserSignInPage.enterPassword(password);
			objUserSignInPage.clickOnLoginBtn();

			Thread.sleep(Constants.AVG_SLEEP);
			objUserDashboardPage.verifyToolbarIsDisplayed();
			LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREEN SCREENSHOT");
			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.clickOnListenersMenu();

			Thread.sleep(Constants.SHORT_SLEEP);
			List<WebElement> listenersnameslist = objUserListenersMenuPage.getAllListenersNamesList();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			for(WebElement listnersname : listenersnameslist) {
				if(listnersname.getText().equalsIgnoreCase("Test 10")) {
					ScrollUtilities.scrollDownWithParam(driver, 50);
					listnersname.click();
					Thread.sleep(Constants.TOOSHORT_SLEEP);
					LogUtilities.extentLogInfoWithScreenShot(driver, "Selected Listener Screen");
					break;
				}
			}
			Thread.sleep(Constants.SHORT_SLEEP);
			//Flow Need to update
	}
}
