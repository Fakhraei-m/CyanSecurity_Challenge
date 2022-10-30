package com.cs.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cs.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
								+"/src/main/java/com/cs/qa/testdata/CS_TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;


	public void SwitchToFrame(String frameName) {
		driver.switchTo().frame(frameName);
	}
	
	public static Object[][] GetTestData(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void TakeScreenshot() throws IOException{
		File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String CurrentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(SrcFile, new File(CurrentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static String StringPurifying(String input) {
		
		String result = input.split("\n")[0];
		return result;
	}
}
