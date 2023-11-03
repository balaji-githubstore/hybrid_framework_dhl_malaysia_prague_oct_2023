package com.dhl.base;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class WebDriverKeywords {

	private WebDriver driver;
	private FluentWait<WebDriver> wait;

	public WebDriverKeywords(WebDriver driver) {
		this.driver = driver;

		wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500)); // by default it is 500ms
		wait.withTimeout(Duration.ofMillis(20000));
		wait.ignoring(Exception.class);
	}

	public void clickOnElement(By locator) {
//		driver.findElement(locator).click();
		wait.until(x -> x.findElement(locator)).click();
	}

	public void typeOnElement(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public String getTextFromElement(By locator) {
		return driver.findElement(locator).getText();
	}

	public String getAttributeValue(By locator, String attributeName) {
		return driver.findElement(locator).getAttribute(attributeName);
	}

	public void switchToTabByTitle(String title) {
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());

		for (String win : windows) {
			driver.switchTo().window(win);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}
}



