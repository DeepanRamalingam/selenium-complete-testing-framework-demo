package com.stackroute.commonclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationSetup {
	
	protected WebDriver driver;
	
	@BeforeClass
	  public void beforeClass() {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
	  
	  public void sleep(long timeout) throws InterruptedException {
		  Thread.sleep(timeout);
	  }
	  
	  public void screenShot(String fileName) throws IOException {
			TakesScreenshot scrnShot = (TakesScreenshot)driver;
			  File scrnShotFile = scrnShot.getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(scrnShotFile,new File("./target/"+fileName+".png"));
		}
	  
	  public List<String[]> csvReader(String filePath) throws IOException {
			
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			CSVReader csvReader = new CSVReader(fileReader);
			List<String[]> credentials = csvReader.readAll();			
			csvReader.close();
			fileReader.close();
			return credentials;
		}
		
		
		public String[][] excelReader(String filePath, String sheetName, int totalCols) throws IOException {
			
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook wb = new XSSFWorkbook(inputStream);
			Sheet sheet = wb.getSheet(sheetName);
			int rows = sheet.getLastRowNum() + 1;
			int cols = totalCols;
			String[][] credentials = new String[rows][cols];
			
			for(int i=0;i<rows;i++) {
				for(int j=0;j<cols;j++) {
					Cell cell = sheet.getRow(i).getCell(j);
					credentials[i][j] = cell.toString();
				}
			}
			
			return credentials;
		}
}
