package com.dhl.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper  {
	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void placeholderTest() {
		String actualUsernamePlaceholder = driver.findElement(By.name("username")).getAttribute("placeholder");
		String actualPasswordPlaceholder = driver.findElement(By.name("password")).getAttribute("placeholder");

		Assert.assertEquals(actualUsernamePlaceholder, "Username");
		Assert.assertEquals(actualPasswordPlaceholder, "Password");
	}

}
