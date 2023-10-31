package com.dhl.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.DashboardPage;
import com.dhl.pages.LoginPage;

public class LoginTest extends AutomationWrapper{
	@Test
	public void validLoginTest()
	{
		LoginPage.enterUsername(driver, "Admin");
		LoginPage.enterPassword(driver, "admin123");
		LoginPage.clickOnLogin(driver);
		
		String actualHeader= DashboardPage.getDashboardHeader(driver);
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest()
	{
		LoginPage.enterUsername(driver, "john");
		LoginPage.enterPassword(driver, "john123");
		LoginPage.clickOnLogin(driver);
		
		//Assert the error - Invalid credentials
		String actualError=LoginPage.getInvalidErrorMessage(driver);
		Assert.assertTrue(actualError.contains("Invalid credentials"));  //except true
	}
	

}
