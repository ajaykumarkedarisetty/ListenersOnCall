package com.listenersoncall.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.listenersoncall.constants.Constants;

public class GenericFunctions {

	public static String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public static String getCurrentTimeOnly() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String getMinusYears() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now().minusYears(20);
		return dtf.format(now);
	}

	public static String getTodayData() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public static String getTodayToSelectCalendar() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now().plusDays(1);
		return dtf.format(now);

	}

	public static String getFutureData(int noOfDays) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now().plusDays(noOfDays);
		return dtf.format(now);

	}

	public static String getCurrentTimeWithMilli() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public static String getCurrentUTCTime() {
		LocalDateTime date = LocalDateTime.now(ZoneOffset.UTC);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String myDate = date.format(dtf);
		return myDate;
	}

	public static String getUTCWithMinusTime(int min) {
		LocalDateTime date = LocalDateTime.now(ZoneOffset.UTC).minusMinutes(min);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String myDate = date.format(dtf);
		return myDate;
	}

	public static String getUTCWithPlusTime(int hrs) {
		LocalDateTime date = LocalDateTime.now(ZoneOffset.UTC).plusHours(hrs);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		String myDate = date.format(dtf);
		return myDate;
	}

	public static int generateRandom() {
		int min = 1;
		int max = 200;
		// Generate random int value from 1 to 200
		System.out.println("Random value in int from " + min + " to " + max + ":");
		int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
		System.out.println(random_int);

		return random_int;
	}

	public static String randomNumeric(int length) {
		String numeric = "123456789";
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int a = (int) (Math.random() * numeric.length());
			builder.append(numeric.charAt(a));
		}
		String rno = builder.toString();
		//System.out.println("RANDOM NUMBERIC GENERATED STRING>>>" + rno);
		return rno;
	}

	public static String randomAlphabet(int length) {
		String numeric = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int a = (int) (Math.random() * numeric.length());
			builder.append(numeric.charAt(a));
		}
		String rno = builder.toString();
		System.out.println("RANDOM ALPHABET GENERATED STRING>>>" + rno);
		return rno;
	}

	public static String samplegetCurrentDate() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public static String getFutureDateForDatePicker(int noOfDays) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now().plusDays(noOfDays);
		return dtf.format(now);
	}

	public static String getOnlyDateForDatePicker(int noOfDays) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d");
		LocalDateTime now = LocalDateTime.now().plusDays(noOfDays);
		return dtf.format(now);
	}
	
	
	public static void uploadSelectedFileAch(WebDriver driver, String filePath) throws Exception {

		Thread.sleep(Constants.TOOSHORT_SLEEP);
		File file = new File(filePath);
		Reporter.log("FILE ABSOLUTE PATH==>" + file.getAbsolutePath(), true);
		StringSelection stringSelection = new StringSelection(file.getAbsolutePath());

		Thread.sleep(Constants.SHORT_SLEEP);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();
		String os_name = System.getProperty("os.name");
		Reporter.log("FILE UPLOADING IN FOLLOWING OS==>"+os_name, true);
		if (os_name.contains("Windows")) { 
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(Constants.TOOSHORT_SLEEP);
		} else { 
			driver.switchTo().window(driver.getWindowHandle());
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.keyPress(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_G);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.keyRelease(KeyEvent.VK_META);
			Thread.sleep(2000);

			// Paste the clipBoard content - Command âŒ˜ + V.
			robot.keyPress(KeyEvent.VK_META);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_META);

			Thread.sleep(2000);
			// Press Enter (GO - To bring up the file.)
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		}

		robot.delay(1000 * 2);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(Constants.TOOSHORT_SLEEP);
		
	}

}
