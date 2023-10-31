package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	public static void clickOnLogin(WebDriver driver) {
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	public static String getInvalidErrorMessage(WebDriver driver)
	{
		return driver.findElement(By.xpath("//p[contains(normalize-space(),'Invalid')]")).getText();
	}
	
	public static String getUsernamePlaceholder(WebDriver driver)
	{
		return driver.findElement(By.name("username")).getAttribute("placeholder");
	}
	
	public static String getPasswordPlaceholder(WebDriver driver)
	{
		return driver.findElement(By.name("password")).getAttribute("placeholder");
	}
}
