package com.listenersoncall.constants;

import java.io.File;

public class Constants {

	public static final String SUITE_DIRECTORY = System.getProperty("user.dir");
	public static final String TESTRESOURCE_PATH = SUITE_DIRECTORY + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources";
	public static final String TESTDATA_PATH = TESTRESOURCE_PATH + File.separator + "TestData";
	public static final String TESTDATAFILE_PATH = TESTDATA_PATH + File.separator + "Test_Data_Sheet.xlsx";
	public static final String PROPERTIESFOLDER_PATH = TESTRESOURCE_PATH + File.separator + "properties";
	public static final String PROPERTYFILE_PATH = PROPERTIESFOLDER_PATH + File.separator + "Config.properties";
	public static final String EXTENTREPORTFOLDER_PATH = SUITE_DIRECTORY + File.separator + "extent-reports";
	public static final String DOWNLOADSFOLDER_PATH = SUITE_DIRECTORY + File.separator + "Downloads";
	
	// wait constants
	public static int TOOSHORT_SLEEP = 2000;
	public static int SHORT_SLEEP = 5000;
	public static int SHORT_IMPLICIT = 5;
	public static int SHORT_EXPLICIT = 10;

	public static int AVG_SLEEP = 10000;
	public static int AVG_IMPLICIT = 10;
	public static int AVG_EXPLICIT = 30;

	public static int LONG_SLEEP = 20000;
	public static int LONG_IMPLICIT = 15;
	public static int LONG_EXPLICIT = 50;
	public static int DOUBLE_LONG_SLEEP = 120000;

	// TestCases Sheet of TestData.xlsx workbook
	public static final int COL_TESTCASENAME = 1;

}
