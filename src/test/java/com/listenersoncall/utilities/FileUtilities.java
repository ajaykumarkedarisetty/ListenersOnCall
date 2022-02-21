package com.listenersoncall.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.Reporter;

import com.opencsv.CSVWriter;

public class FileUtilities {

	public static String createParentDir(String suiteLoc, String name) {
		File file = new File(suiteLoc + "/" + name);
		if (!file.exists()) {
			if (file.mkdir()) {
				Reporter.log("DIRECTORY IS CREATED WITH"+name, true);
			} else {
				Reporter.log("FAILD TO CREATE DIRECTORY WITH"+name, true);
			}
		}
		return file.getAbsolutePath();
	}

	/* Check the file from a specific directory with extension */
	public static boolean isFileDownloaded_Ext(String dirPath, String ext) {
		boolean flag = false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if (files[i].getName().contains(ext)) {
				flag = true;
			}
		}
		return flag;
	}

	/* Check the file from a specific directory with filename */
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}
		return flag;
	}

	/* Get the latest file from a specific directory */
	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}
	
	
	public static void printCustomerList(String path) {
		try {
			FileWriter outputfile = new FileWriter(path, true);
			CSVWriter writer = new CSVWriter(outputfile);
			outputfile.append("\n");
			List<String[]> data = new ArrayList<String[]>();
			for (int i = 0; i < 5; i++) {
				String lastName = GenericFunctions.randomNumeric(3);
				data.add(new String[] { "", "", "", "", "Joseph", "", lastName, "2106063799", "", "joseph_"+ lastName +"@mailinator.com",
						"29788", "", "1982-05-31", "male", "AdiClient", "" });
			}
			writer.writeAll(data);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeData(String strFilePath) {

	    PrintWriter csvWriter;
	    try {
	        /*1. declare stringBuffer*/
	        StringBuffer oneLineStringBuffer = new StringBuffer();

	        File file = new File(strFilePath);
	        if (!file.exists()) {
	            file = new File(strFilePath);

	        }
	        csvWriter = new PrintWriter(new FileWriter(file, true));

	        /*2. append to stringBuffer*/   
	       // oneLineStringBuffer.append(data + "," + "hello");
	        oneLineStringBuffer.append("\n");
	        oneLineStringBuffer.append("" + "," + "" + "," + "" + "," + "" + "," + "Adi");
	        
	        /*3. print to csvWriter*/
	        csvWriter.print(oneLineStringBuffer);

	        csvWriter.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public static void main(String[] args) throws IOException {
		String path = "D:\\Automation\\Eclipse_Workspace\\ListenersOnCall_Automation\\Downloads\\Adi Test.csv";
		writeData(path);
		//printCustomerList(path);
	}
	
	
}
