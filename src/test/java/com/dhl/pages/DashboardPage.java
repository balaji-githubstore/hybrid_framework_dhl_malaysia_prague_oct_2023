package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	public static String getDashboardHeader(WebDriver driver)
	{
		return driver.findElement(By.xpath("//h6[contains(normalize-space(),'Dash')]")).getText();
	}

}
