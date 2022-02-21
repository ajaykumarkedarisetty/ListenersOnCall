package com.listenersoncall.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.LogUtilities;
import com.listenersoncall.utilities.WaitLibrary;

public class UserCreateNewAccountPage {

	WebDriver driver;

	public By createAccountPageTitle = By.xpath("//h3[text()='My Account']");
	public By createAccountPageHelpText = By.xpath("//label[contains(text(),'Confirm or complete your account information')]");
	public By groudIdTextBox = By.xpath("//div[@data-cy-welcomescreenstepfour-groupid='true']//input");
	public By firstNameTextBox = By.xpath("//input[@name='firstName']");
	public By lastNameTextBox = By.xpath("//input[@name='lastName']");
	public By emailTextBox = By.xpath("//input[@name='email']");
	public By phoneNumberTextBox = By.xpath("//div[@data-cy-welcomescreenstepfour-phonenumber='true']//input");
	public By genderDropDown = By.xpath("//select[@data-cy-welcomescreenstepfour-gender='true']");
	public By dateOfBirthTextBox = By.xpath("//div[@class='react-datepicker__input-container']//input[@type='text']");
	public By datePickerCloseBtn = By.xpath("//button[@class='react-datepicker__close-icon']");
	public By selectedCurrentDate = By.xpath("//div[contains(@class,'react-datepicker__day--selected')]");
	public By timeZoneDropdown = By.xpath("//div[@data-cy-welcomescreenstepfour-timezone='true']//select");
	public By zipCodeTextBox = By.xpath("//input[@type='number']");
	public By createPasswordTextBox = By.xpath("//div[@data-cy-welcomescreenstepfour-password='true']//input[@type='password']");
	public By confirmPasswordTextBox = By.xpath("//div[@data-cy-welcomescreenstepfour-confirmpassword='true']//input[@type='password']");
	public By nextButton = By.xpath("//div[@class='px-7.5']");
	public By termsRadioBtn = By.xpath("//input[@type='radio']");
	public By getStartedBtn = By.xpath("//button[text()='GET STARTED']");
	public By createAccountCloseBtn = By.xpath("//img[@alt='cancel']");
	public By areYouSureAlertTxt = By.xpath("//h3[contains(text(),'Are you sure you want to end the')]");
	public By endAccountCreationBtn = By.xpath("//button[contains(text(),'end account creation')]");
	public By continueAccountCreationBtn = By.xpath("//button[contains(text(),'continue account creation')]");

	public UserCreateNewAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void verifyCreateAccountPageisDisplayed() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountPageTitle);
		boolean flag = driver.findElement(createAccountPageTitle).isDisplayed();
		assertTrue(flag,"Create Account 'My Account' Page is not Displayed");
		LogUtilities.extentLogPass("Create Account 'My Account' Page is Displayed");
	}
	
	
	public void verifyCreateAccountPageTitle() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountPageTitle);
		String actualTitle = driver.findElement(createAccountPageTitle).getText();
		assertEquals(actualTitle,"My Account");
		LogUtilities.extentLogPass("Verified Create Account Page Tilte, Actual Title=>"+actualTitle);
	}
	
	public void verifyCreateAccountPageHelpText() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, createAccountPageHelpText);
		String actualTitle = driver.findElement(createAccountPageHelpText).getText();
		assertEquals(actualTitle,"Confirm or complete your account information and you’ll be all set.");
		LogUtilities.extentLogPass("Verified Create Account Page Help Text, Actual Title=>"+actualTitle);
	}
	
	public void verifyFirstNameisDisplayed() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, firstNameTextBox);
		boolean flag = driver.findElement(firstNameTextBox).isDisplayed();
		assertTrue(flag,"First Name Field is not displayed");
		LogUtilities.extentLogPass("First Name Field Is Displayed");
	}
	
	public void enterFirstName(String firstname) {
		driver.findElement(firstNameTextBox).sendKeys(firstname);
		LogUtilities.extentLogPass("Value entered value in first name is=>" + firstname);
	}
	
	public void enterLastName(String lastname) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, lastNameTextBox);
		driver.findElement(lastNameTextBox).sendKeys(lastname);
		LogUtilities.extentLogPass("Value entered in Last name is=>" + lastname);
	}
	
	public void enterEmail(String email) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, emailTextBox);
		driver.findElement(emailTextBox).sendKeys(email);
		LogUtilities.extentLogPass("Value entered in Email is=>" + email);
	}
	
	public void enterPhoneNumber(String number) {
		driver.findElement(phoneNumberTextBox).sendKeys(number);
		LogUtilities.extentLogPass("Value entered in PhoneNumber is=>" + number);
	}

	public void selectGender(String selectvalue) {
		Select gender = new Select(driver.findElement(genderDropDown));
		gender.selectByValue(selectvalue);
		LogUtilities.extentLogPass("Selected GENDER Y=>" + selectvalue + " from GENDER Dropdown");
	}

	public void clickOnDatePickerClose() {
		driver.findElement(phoneNumberTextBox).click();
		LogUtilities.extentLogPass("Clicked On DatePicker Close Button.");
	}

	public void clickOnSelectedDate() {
		driver.findElement(selectedCurrentDate).click();
		LogUtilities.extentLogPass("Clicked On Selected Date.");
	}
	
	
	public void enterDateofBirth(String date) throws InterruptedException {
		driver.findElement(dateOfBirthTextBox).click();
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		driver.findElement(dateOfBirthTextBox).sendKeys(Keys.CONTROL + "A");
		driver.findElement(dateOfBirthTextBox).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		driver.findElement(dateOfBirthTextBox).sendKeys(date);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		clickOnSelectedDate();
		LogUtilities.extentLogPass("Value entered in Date Of Birth Textbox=>" + date);
	}
	
	public void selectTimezone(String selectvalue) {
		Select timezone = new Select(driver.findElement(timeZoneDropdown));
		timezone.selectByValue(selectvalue);
		LogUtilities.extentLogPass("Selected TimeZone As=>" + selectvalue + " from TIMEZONE Dropdown");
	}
	
	
	public void enterZipCode(String zipcode) {
		driver.findElement(zipCodeTextBox).sendKeys(zipcode);
		LogUtilities.extentLogPass("Value entered in ZIPCODE is=>" + zipcode);
	}
	
	public void enterPassword(String pswd) {
		driver.findElement(createPasswordTextBox).sendKeys(pswd);
		LogUtilities.extentLogPass("Value entered in PASSWORD Textbox is=>" + pswd);
	}
	
	public void enterConfirmPassword(String pswd) {
		driver.findElement(confirmPasswordTextBox).sendKeys(pswd);
		LogUtilities.extentLogPass("Value entered in CONFIRM PASSWORD Textbox is=>" + pswd);
	}
	
	public void createNewAccount(String firstname, String lastname, String email, String phonenumber,
			String gendervalue, String dob, String timezone, String zipcode, String password) throws InterruptedException {
		enterFirstName(firstname);
		enterLastName(lastname);
		enterEmail(email);
		enterPhoneNumber(phonenumber);
		selectGender(gendervalue);
		enterDateofBirth(dob);
		selectTimezone(timezone);
		enterZipCode(zipcode);
		enterPassword(password);
		enterConfirmPassword(password);
	}
	
	public void clickOnNextBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, nextButton);
		driver.findElement(nextButton).click();
		LogUtilities.extentLogPass("Clicked on NEXT button");
	}

	public void clickOnTermsRadioBtn() {
		driver.findElement(termsRadioBtn).click();
		LogUtilities.extentLogPass("Clicked on TERMS ON CONDITIONS Radio Button");
	}

	public void clickOnGetStartedBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, getStartedBtn);
		driver.findElement(getStartedBtn).click();
		LogUtilities.extentLogPass("Clicked on GET STARTED Button");
	}
	
	public void clickOnCreateAccountCloseBtn() {
		driver.findElement(createAccountCloseBtn).click();
		LogUtilities.extentLogPass("Clicked On Close Button.");
	}
	
	public void verifyAreYouSureAlertText(String expectedtxt) {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, areYouSureAlertTxt);
		String actualTxt = driver.findElement(areYouSureAlertTxt).getText();
		assertEquals(actualTxt, expectedtxt);
		LogUtilities.extentLogPass("Verified Alert Text, Actual Text=>"+actualTxt + " ,Expected Text=>"+expectedtxt);
	}
	
	public void clickOnendAccountCreationBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, endAccountCreationBtn);
		driver.findElement(endAccountCreationBtn).click();
		LogUtilities.extentLogPass("Clicked On 'End Account Creation' Button.");
	}
	
	public void clickOncontinueAccountCreationBtn() {
		WaitLibrary.waitForElementPresence(driver, Constants.AVG_EXPLICIT, continueAccountCreationBtn);
		driver.findElement(continueAccountCreationBtn).click();
		LogUtilities.extentLogPass("Clicked On 'Continue Account Creation' Button.");
	}
	
}
