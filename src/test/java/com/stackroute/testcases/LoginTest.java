package com.stackroute.testcases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.stackroute.commonclasses.AutomationSetup;
import com.stackroute.pageobjects.DashboardPage;
import com.stackroute.pageobjects.LoginPage;

public class LoginTest extends AutomationSetup {
  

  @Ignore
  @Test
  public void f() throws InterruptedException, IOException {
	  
	  PageFactory.initElements(driver, LoginPage.class);
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  LoginPage.username.sendKeys("Admin");
	  LoginPage.password.sendKeys("admin123");
	  LoginPage.loginBtn.click();
	  sleep(3000);
	  
	  screenShot("login-success-page");
	  PageFactory.initElements(driver, DashboardPage.class);
	  Boolean welcomeElement = DashboardPage.welcome != null;
	  Assert.assertTrue(welcomeElement);
		
  }
  
  
  @Test(groups = {"smoke"})
	public void sample1_from_loginTest() {
		
		Assert.assertTrue(true);
	}
  
  @Test
	public void sample2_from_loginTest() {
		
		Assert.assertTrue(true);
	}

}
