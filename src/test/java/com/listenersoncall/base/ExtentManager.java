package com.listenersoncall.base;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.listenersoncall.constants.Constants;
import com.listenersoncall.utilities.PropertiesOperation;

public class ExtentManager {

	private static ExtentReports extent;
	
	private static String reportFileName = "ListenetsOnCall_TestCase_Report";
	private static String fileSeperator = System.getProperty("file.separator");
	private static String reportFilePath = Constants.EXTENTREPORTFOLDER_PATH + fileSeperator;
	private static String reportFileLocation = "";

	public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }
	
	public static ExtentReports createInstance() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		reportFileLocation = reportFilePath + reportFileName + "_" + actualDate + ".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportFileLocation);
		
		sparkReport.config().setEncoding("utf-8");
		sparkReport.config().setDocumentTitle("ListenersOnCall Automation Report");
		sparkReport.config().setReportName("ListenersOnCall_TestCases_Report");
		sparkReport.config().setTheme(Theme.STANDARD);
		
		
		extent = new ExtentReports();
		extent.setSystemInfo("Executed on Browser: ", PropertiesOperation.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
		extent.setSystemInfo("Executed on User: ", System.getProperty("user.name"));
		extent.attachReporter(sparkReport);

		return extent;

	}
	
	
}
