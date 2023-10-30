package com.dhl.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper{
	@Test
	public void validLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String actualHeader= driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test
	public void invalidLoginTest()
	{
		driver.findElement(By.name("username")).sendKeys("john");
		driver.findElement(By.name("password")).sendKeys("john123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Assert the error - Invalid credentials
	}
	

}
