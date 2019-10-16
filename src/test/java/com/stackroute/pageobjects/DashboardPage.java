package com.stackroute.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	@FindBy(linkText = "Welcome Admin")
	public static WebElement welcome;

}
