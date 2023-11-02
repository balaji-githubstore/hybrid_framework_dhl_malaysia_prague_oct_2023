package com.dhl.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.dhl.base.AutomationWrapper;
import com.dhl.pages.LoginPage;

public class LoginUITest extends AutomationWrapper  {
	@Test(groups = {"ui","smoke"})
	public void titleTest() {
		String actualTitle = driver.getTitle();
		test.info("Actual title is "+actualTitle);
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test(groups = {"ui"} )
	public void placeholderTest() {
		LoginPage loginPage=new LoginPage(driver);
		Assert.assertEquals(loginPage.getUsernamePlaceholder(), "Username");
		Assert.assertEquals(loginPage.getPasswordPlaceholder(), "Password");
	}

}
