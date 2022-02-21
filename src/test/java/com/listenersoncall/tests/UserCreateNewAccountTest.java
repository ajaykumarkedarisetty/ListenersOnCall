package com.listenersoncall.tests;

import org.testng.annotations.Test;

import com.listenersoncall.base.TestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.UserCreateNewAccountPage;
import com.listenersoncall.pages.UserDashboardPage;
import com.listenersoncall.pages.UserWelcomePage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.GenericFunctions;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.ScrollUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class UserCreateNewAccountTest extends TestBase{
	
	UserWelcomePage objUserWelcomePage;
	UserCreateNewAccountPage objUserCreateNewAccountPage;
	UserDashboardPage objUserDashboardPage;
	
	@Test
	public void verifyNewAccountCreationFunctionality() throws Exception {
			
		try {
		
		String firstnamevalue = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 3);
		String lastnamevalue = GenericFunctions.randomNumeric(4);
		String emaildomain = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 4);;
		String phonenumbervalue = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 5);
		String gendervalue = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 6);
		String timezonevalue = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 7);
		String zipcodevalue = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 8);
		String password = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, 
				"CreateAccount", "CreateNewAccountValid", 9);

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);
		
		objUserWelcomePage.clickOnCreateAccount();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		String generateddob = GenericFunctions.getMinusYears();
		String generatedemail = firstnamevalue + "+" + lastnamevalue + emaildomain;
		
		objUserCreateNewAccountPage.createNewAccount(firstnamevalue, lastnamevalue, generatedemail, 
													phonenumbervalue, gendervalue, generateddob, 
													timezonevalue, zipcodevalue, password);
		ScrollUtilities.scrollDown(driver);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage.clickOnNextBtn();
		
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, objUserCreateNewAccountPage.termsRadioBtn);
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserCreateNewAccountPage.clickOnTermsRadioBtn();
		ScrollUtilities.scrollDown(driver);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage.clickOnGetStartedBtn();
		
		Thread.sleep(Constants.AVG_SLEEP);
		objUserDashboardPage.verifyLetsTalkAboutText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURED DASHBOARD SCREENSHOT");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void verifyEndAccountCreationFunctionality() throws InterruptedException {

		objUserWelcomePage = new UserWelcomePage(driver);
		objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
		objUserDashboardPage = new UserDashboardPage(driver);

		objUserWelcomePage.clickOnCreateAccount();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage
				.verifyAreYouSureAlertText("Are you sure you want to end the account creation process?");

		objUserCreateNewAccountPage.clickOnendAccountCreationBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objUserDashboardPage.verifyLetsTalkAboutText();
		LogUtilities.extentLogInfoWithScreenShot(driver, "Application Navigated to Dashboard Screen");
	}
	
	@Test
	public void verifyContinueAccountCreationFunctionality() throws InterruptedException {
		
		objUserWelcomePage = new UserWelcomePage(driver);
		objUserCreateNewAccountPage = new UserCreateNewAccountPage(driver);
		
		objUserWelcomePage.clickOnCreateAccount();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage.clickOnCreateAccountCloseBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		LogUtilities.extentLogInfoWithScreenShot(driver, "CAPTURE ALERT SCREEN SCREENSHOT");
		objUserCreateNewAccountPage.clickOncontinueAccountCreationBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objUserCreateNewAccountPage.verifyFirstNameisDisplayed();
		LogUtilities.extentLogInfoWithScreenShot(driver, "Application Navigated to 'Create Account' Screen");
	}

}
