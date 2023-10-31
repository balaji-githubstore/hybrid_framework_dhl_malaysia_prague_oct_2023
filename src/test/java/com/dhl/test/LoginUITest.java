package com.dhl.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.LoginPage;

public class LoginUITest extends AutomationWrapper  {
	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void placeholderTest() {
		Assert.assertEquals(LoginPage.getUsernamePlaceholder(driver), "Username");
		Assert.assertEquals(LoginPage.getPasswordPlaceholder(driver), "Password");
	}

}
