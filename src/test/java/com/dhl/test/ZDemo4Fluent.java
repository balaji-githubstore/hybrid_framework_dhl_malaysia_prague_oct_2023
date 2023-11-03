package com.dhl.test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class ZDemo4Fluent {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/");
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofMillis(500)); //by default it is 500ms
		wait.withTimeout(Duration.ofMillis(20000));
		wait.ignoring(NoSuchElementException.class,NoAlertPresentException.class);
		
		
		
	}

}
