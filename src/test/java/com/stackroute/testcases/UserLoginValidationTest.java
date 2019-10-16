package com.stackroute.testcases;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.stackroute.commonclasses.AutomationSetup;
import com.stackroute.pageobjects.DashboardPage;
import com.stackroute.pageobjects.LoginPage;

public class UserLoginValidationTest extends AutomationSetup {

	@DataProvider(name = "username-provider")
	public Object[][] provideUserCredentials() {
		Object[][] credentials = 
								{ 	{"deepan","pass123",false},
									{"sachin","pass234",false},
									{"dinesh","pas22237",false},
									{"Admin","admin123",true}
								};
		return credentials;
	}
	
	@DataProvider(name = "csv-data-provider")
	public Iterator<String[]> provideUserCredentialsCSV() throws IOException{
		return csvReader("./src/test/resources/userCredentials.csv").iterator();
	}
	
	@DataProvider(name = "excel-data-provider")
	public String[][] provideUserCredentialsEXCEL() throws IOException{
		String filePath = "./src/test/resources/login_data.xlsx";
		return excelReader(filePath,"Sheet1",3);
	}

	@Ignore
	@Test(dataProvider = "excel-data-provider")
	public void validateUser(String user, String pass, String isValidAsString) throws IOException, InterruptedException {
		
		Boolean isValid = Boolean.valueOf(isValidAsString);
		PageFactory.initElements(driver, LoginPage.class);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		LoginPage.username.sendKeys(user);
		LoginPage.password.sendKeys(pass);
		LoginPage.loginBtn.click();
		sleep(3000);
		
		if(isValid) {
			  screenShot(user+"-login-status");
			  PageFactory.initElements(driver, DashboardPage.class);
			  Boolean welcomeElement = DashboardPage.welcome != null;
			  Assert.assertTrue(welcomeElement);
		} else {
				screenShot(user+"-login-status");
				Boolean errorElement = driver.findElement(By.id("spanMessage")) != null;
				Assert.assertTrue(errorElement);
		}
		
	}
	
		
	
	@Test(groups = {"smoke"})
	public void sample1_from_user_validation() {
		
		Assert.assertTrue(false);
	}
	
	@Test
	public void sample2_from_user_validation() {
		
		Assert.assertTrue(true);
	}

}
