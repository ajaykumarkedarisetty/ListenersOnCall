package com.listenersoncall.tests;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.listenersoncall.base.AdminTestBase;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.pages.AdminDashboardPage;
import com.listenersoncall.pages.AdminGroupsMenuPage;
import com.listenersoncall.pages.AdminSignInPage;
import com.listenersoncall.utilities.ExcelUtilities;
import com.listenersoncall.utilities.FileUtilities;
import com.listenersoncall.utilities.GenericFunctions;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class AdminNewUserAddTest extends AdminTestBase {

	AdminSignInPage objAdminSignInPage;
	AdminDashboardPage objAdminDashboardPage;
	AdminGroupsMenuPage objAdminGroupsMenuPage;
		
	@Test
	public void verifyAdminAddUserFunctionality() throws Exception {

		String username = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, "SignInTestData",
				"AdminLoginDetails", 2);
		String password = ExcelUtilities.getCellDataBySheetName(Constants.TESTDATAFILE_PATH, "SignInTestData",
				"AdminLoginDetails", 3);
		objAdminSignInPage = new AdminSignInPage(driver);
		objAdminDashboardPage = new AdminDashboardPage(driver);
		objAdminGroupsMenuPage = new AdminGroupsMenuPage(driver);
		
		objAdminSignInPage.adminLogin(username, password);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, objAdminDashboardPage.logOutBtnLocator);
		LogUtilities.extentLogInfoWithScreenShot(driver, "Capture Screenshot for Dashboard Screen");
		
		objAdminDashboardPage.clickOnMenu("Groups");
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, objAdminGroupsMenuPage.firstRecordNameLocator);
		
		List<WebElement>groupNamesList = objAdminGroupsMenuPage.getGroupsList();
		for (int gpl = 0; gpl < groupNamesList.size(); gpl++) {
			String actualGroupName = groupNamesList.get(gpl).getText();
			if(actualGroupName.equalsIgnoreCase("Adi Test")) {
				objAdminGroupsMenuPage.clickOnArrowButton(gpl+1);
				break;
			}
		}
		
		objAdminGroupsMenuPage.clickOnEligibilityTab();
		objAdminGroupsMenuPage.clickOnDownloadMembersBtn();
		Thread.sleep(Constants.AVG_SLEEP);
		File downloadedFilePath  = FileUtilities.getLatestFilefromDir(Constants.DOWNLOADSFOLDER_PATH);
		FileUtilities.printCustomerList(downloadedFilePath.getAbsolutePath());
		objAdminGroupsMenuPage.clickOnscheduleEligibilityUploadBtn();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		objAdminGroupsMenuPage.clickOnUploadFileBtn();
		GenericFunctions.uploadSelectedFileAch(driver, downloadedFilePath.getAbsolutePath());
		objAdminGroupsMenuPage.clickOnValidateFileBtn();
		Thread.sleep(Constants.SHORT_SLEEP);
		objAdminGroupsMenuPage.clickOnuploadAfterValidate();
		
	}

}
