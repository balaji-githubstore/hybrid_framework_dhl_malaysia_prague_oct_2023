package com.dhl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Handle menu and profile section webelement - common webelements
 */
public class MainPage {

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnPIMMenu() {
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
	}
}
