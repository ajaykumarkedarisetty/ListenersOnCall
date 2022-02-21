package com.listenersoncall.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.listenersoncall.utilities.LogUtilities;

public class AdminGroupsMenuPage {

	WebDriver driver;
	public By firstRecordNameLocator = By.xpath("(//div[@class='font-bold font-base'])[position()=1]");
	public By firstRecordStatusBtnLocator = By.xpath("(//button[text()='ACTIVE' or text()='SETUP'])[position()=1]");
	public By firstRecordArrowBtnLocator = By.xpath("(//div[contains(@class,'bg-white')])[position()=1]");
	public By groupNamesListLocator = By.xpath("//div[@class='font-bold font-base']");
	

	//Individual Group
	public By eligibilityTabLocator = By.xpath("//button[text()='Eligibility']");
	public By downloadMembersBtnLocator = By.xpath("//button[text()='DOWNLOAD MEMBERS']");
	public By scheduleEligibilityUploadBtnLocator = By.xpath("//button[text()='UPLOAD']");
	
	//Upload Eligibility File Locator
	public By uploadFileLocator = By.xpath("//div[text()='Upload file']");
	public By validateFileBtnLocator = By.xpath("//button[text()='VALIDATE']");
	public By viewBtnLocator = By.xpath("//button[text()='VIEW']");
	public By uploadAfterValidateLocator = By.xpath("//button[@class='px-7 py-2 text-sm btn-darkblue' and text()='UPLOAD']");
	public By cancelEligibilityBtnLocator = By.xpath("//button[text()='Cancel']");
	
	public AdminGroupsMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnFirstArrow() {
		driver.findElement(firstRecordArrowBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'ARROW' Menu.");
	}
	
	public List<WebElement> getGroupsList(){
		return driver.findElements(groupNamesListLocator);
	}
	
	public void clickOnArrowButton(int position) {
		driver.findElement(By.xpath("(//div[contains(@class,'bg-white')])[position()=" + position + "]")).click();
		LogUtilities.extentLogPass("Clicked On 'ARROW' Menu.");
	}
	
	public void clickOnEligibilityTab() {
		driver.findElement(eligibilityTabLocator).click();
		LogUtilities.extentLogPass("Clicked On 'ELIGIBILITY' Tab.");
	}
	
	public void clickOnDownloadMembersBtn() {
		driver.findElement(downloadMembersBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'DOWNLOAD MEMBERS' Tab.");
	}
	
	public void clickOnscheduleEligibilityUploadBtn() {
		driver.findElement(scheduleEligibilityUploadBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'UPLOAD' Button.");
	}

	//Upload Eligibility Upload File Locator
	public void clickOnUploadFileBtn() {
		driver.findElement(uploadFileLocator).click();
		LogUtilities.extentLogPass("Clicked On 'UPLOAD FILE' Button.");
	}
	
	public void clickOnValidateFileBtn() {
		driver.findElement(validateFileBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'VALIDATE FILE' Button.");
	}
	
	public void clickOnuploadAfterValidate() {
		driver.findElement(uploadAfterValidateLocator).click();
		LogUtilities.extentLogPass("Clicked On 'UPLOAD' Button.");
	}
	
	public void clickOncancelEligibilityBtn() {
		driver.findElement(cancelEligibilityBtnLocator).click();
		LogUtilities.extentLogPass("Clicked On 'CANCEL' Button.");
	}
	
}
