package com.stackroute.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stackroute.commonclasses.AutomationSetup;

public class TestClass_3 extends AutomationSetup {
	
	@Test(groups = {"smoke"})
	public void sample1_from_testclass_3() {
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void sample2_from_testclass_3() {
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void sample3_from_testclass_3() {
		
		Assert.assertTrue(true);
	}

}
