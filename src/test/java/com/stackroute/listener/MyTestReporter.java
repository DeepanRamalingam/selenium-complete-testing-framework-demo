package com.stackroute.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class MyTestReporter implements ITestListener{

	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" started successfully");
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" SUCCESS");
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" Failed");
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" SKIPPED");
	}


}
