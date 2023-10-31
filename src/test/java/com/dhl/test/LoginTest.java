package com.dhl.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.DashboardPage;
import com.dhl.pages.LoginPage;
import com.dhl.utils.DataUtils;

public class LoginTest extends AutomationWrapper {
	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();

		DashboardPage dashboardPage = new DashboardPage(driver);
		String actualHeader = dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, "Dashboard");
	}

	@Test(dataProvider = "invalidLoginData", dataProviderClass = DataUtils.class)
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
