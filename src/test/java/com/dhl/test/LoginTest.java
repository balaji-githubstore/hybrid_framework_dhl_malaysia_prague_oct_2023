package com.dhl.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.DashboardPage;
import com.dhl.pages.LoginPage;
import com.dhl.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login","smoke"})
	public void validLoginTest(String username,String password,String expectedHeader) {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String actualHeader = dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, expectedHeader);
	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidLoginTest(String username, String password, String expectedError) {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLogin();

		// Assert the error - Invalid credentials
		String actualError = loginPage.getInvalidErrorMessage();
		Assert.assertTrue(actualError.contains(expectedError)); // except true
	}
}
