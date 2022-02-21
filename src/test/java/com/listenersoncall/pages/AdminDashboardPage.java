package com.listenersoncall.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class AdminDashboardPage {

	WebDriver driver;
	public By logOutBtnLocator = By.xpath("//button[text()='LOG OUT']");

	public AdminDashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnLogOut() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, logOutBtnLocator);
		driver.findElement(logOutBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'LOG OUT' Button.");
	}

	public void clickOnMenu(String menuname) {
		driver.findElement(By.xpath("//div[@class='relative ']//button[text()='" + menuname + "']")).click();
		LogUtilities.extentLogPass("Clicked On '" + menuname + "' Menu.");
	}

}
