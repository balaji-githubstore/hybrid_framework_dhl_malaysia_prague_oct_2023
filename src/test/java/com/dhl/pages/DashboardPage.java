package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.dhl.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {
	
	private By dashboardHeaderLocator=By.xpath("//h6[contains(normalize-space(),'Dash')]");
	
	private WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public String getDashboardHeader()
	{
//		return driver.findElement(dashboardHeaderLocator).getText();
		return super.getTextFromElement(dashboardHeaderLocator);
	}

	
}
