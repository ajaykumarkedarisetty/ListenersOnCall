package com.listenersoncall.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.listenersoncall.constants.Constants;

public class ExcelUtilities {

	public static FileInputStream ExcelFile = null;
	public static FileOutputStream fileOut = null;

	public static XSSFSheet ExcelWSheet = null;
	public static XSSFWorkbook ExcelWBook = null;
	public static XSSFCell Cell = null;
	public static XSSFRow Row = null;

	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			// Open the Excel file
			ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getCellDataBySheetName(String path, String SheetName, String TestCaseName, int ColNum)
			throws Exception {

		try {
			String CellData;
			int TestCaseRow = ExcelUtilities.getRowContainsBySheetName(path, SheetName, TestCaseName,
					Constants.COL_TESTCASENAME);
			Cell = ExcelWSheet.getRow(TestCaseRow).getCell(ColNum);
			CellType cellType = Cell.getCellType();
			if (cellType.toString().equals("NUMERIC")) {
				Double d = Cell.getNumericCellValue();
				long intCellData = (long) Cell.getNumericCellValue();
				CellData = String.valueOf(intCellData);
			} else {
				CellData = Cell.getStringCellValue();
			}
			return CellData;
		} catch (Exception e) {
			return "";

		} finally {
			ExcelFile.close();
		}
	}


	public static void setCellDataBySheetName(String path, String SheetName, int RowNum, int ColNum, String Result)
			throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			throw (e);
		}

		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
				XSSFCellStyle style1 = ExcelWBook.createCellStyle();
				style1.setFillForegroundColor(IndexedColors.WHITE.index);
				Cell.setCellStyle(style1);
			} else {
				Cell.setCellValue(Result);
				XSSFCellStyle style1 = ExcelWBook.createCellStyle();
				style1.setFillForegroundColor(IndexedColors.WHITE.index);
				Cell.setCellStyle(style1);
			}

			// Constant variables Test Data path and Test Data file name
			fileOut = new FileOutputStream(path);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;

		try {
			int rowCount = ExcelUtilities.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtilities.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContainsBySheetName(String path, String SheetName, String sTestCaseName, int colNum)
			throws Exception {

		int i;

		try {
			ExcelUtilities.setExcelFile(path, SheetName);
			int rowCount = ExcelUtilities.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ExcelUtilities.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {

		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}
	
}
