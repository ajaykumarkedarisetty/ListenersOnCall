package com.listenersoncall.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserSignInPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.LogUtilities;

public class UserDashboardPageTest extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserSignInPage objUserSignInPage;
	UserDashboardPage objUserDashboardPage;
	
		
	@Test
	public void verifyDashboardUIFunctionality() throws Exception {
			
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
			
			objUserDashboardPage.verifyLetsTalkAboutText();
			objUserDashboardPage.verifyLetsTalkAboutMoreTxt();
			objUserDashboardPage.verifySuggestedListenersTxt();
			objUserDashboardPage.verifySuggestedListenersExploreTxt();
			objUserDashboardPage.verifyMyResourceTxt();
			objUserDashboardPage.verifyMyResourceMoreTxt();
			objUserDashboardPage.verifyMyProgramTxt();
			objUserDashboardPage.verifyMyProgramVisitTxt();
			
			List<WebElement> letsTalkAboutList  = objUserDashboardPage.getAllLetsTalkAboutList();
			for(WebElement talkList : letsTalkAboutList) {
				talkList.isDisplayed();
			}
			LogUtilities.extentLogPass("Records Displayed Uunder LETS TALK ABOUT Are=>"+letsTalkAboutList.size());

			List<WebElement> suggestedListenersList  = objUserDashboardPage.getAllSuggestedListenersList();
			for(WebElement suggestedlistenerslist : suggestedListenersList) {
				suggestedlistenerslist.isDisplayed();
			}
			LogUtilities.extentLogPass("Records Displayed Under SUGGESTED LISTENERS Are=>"+suggestedListenersList.size());
			
			List<WebElement> myResourcesList  = objUserDashboardPage.getAllMyResourcesList();
			for(WebElement myresourceslist : myResourcesList) {
				myresourceslist.isDisplayed();
			}
			LogUtilities.extentLogPass("Records Displayed Under MY RESOURCES Are=>"+myResourcesList.size());
			
			List<WebElement> myProgramList  = objUserDashboardPage.getAllMyProgramList();
			for(WebElement myprogramlist : myProgramList) {
				myprogramlist.isDisplayed();
			}
			LogUtilities.extentLogPass("Records Displayed Under MY PROGRAM Are=>"+myProgramList.size());
			
			objUserDashboardPage.clickOnSideMenuBtn();
			Thread.sleep(Constants.TOOSHORT_SLEEP);
			objUserDashboardPage.verifySideMenuListElement("Listeners", "Listeners");
			objUserDashboardPage.verifySideMenuListElement("Experiences", "Experiences");
			objUserDashboardPage.verifySideMenuListElement("Library", "Library");
			objUserDashboardPage.verifySideMenuListElement("My Profile", "My Profile");
			objUserDashboardPage.verifySideMenuListElement("My Preferences", "My Preferences");
			objUserDashboardPage.verifySideMenuListElement("My Program", "My Program");
			objUserDashboardPage.verifySideMenuListElement("Payment", "Payment");
			objUserDashboardPage.verifySideMenuListElement("Resources", "Resources");
			objUserDashboardPage.verifySideMenuListElement("Support", "Support");
			objUserDashboardPage.verifySideMenuListElement("About", "About");
			
	}
}
