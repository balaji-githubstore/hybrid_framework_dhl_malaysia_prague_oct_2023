package com.dhl.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class ZDemo5Fluent2 {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com");
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500)); //by default it is 500ms
		wait.withTimeout(Duration.ofMillis(20000));
//		wait.ignoring(StaleElementReferenceException.class,NoAlertPresentException.class);
		wait.ignoring(Exception.class);
		
//		WebElement ele= wait.until(x->x.findElement(By.tagName("a")));
		
//		ele.click();
		wait.until(x->x.findElement(By.tagName("a"))).click();
		
	}

}
