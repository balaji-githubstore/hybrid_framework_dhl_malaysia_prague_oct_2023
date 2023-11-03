package com.dhl.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ZDemo5FB {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/"); //wait for page load to complete
		
//		//all findElement method - takes only 0.5 sec to check the presence of element
//		driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();
//		
//		driver.findElement(By.linkText("Create new account")).click();
//		
//		driver.findElement(By.name("firstname")).sendKeys("john");
//		
//		//enter lastname as wick
//		driver.findElement(By.name("lastname")).sendKeys("wick");
		
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.ignoring(Exception.class);
		
		String title=wait.until(x->x.getTitle());
		System.out.println(title);
		
		wait.until(x->x.findElement(By.xpath("//button[@title='Allow all cookies']"))).click();
		
		wait.until(x->x.findElement(By.linkText("Create new account"))).click();
		
		wait.until(x->x.findElement(By.name("firstname"))).sendKeys("john");
		
		wait.until(x->x.switchTo().alert()).accept();
		
		String text=wait.until(x->x.findElement(By.xpath("")).getText());
		 
	}
}
