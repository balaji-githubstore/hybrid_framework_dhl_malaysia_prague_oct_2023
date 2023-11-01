package com.dhl.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.dhl.base.AutomationWrapper;
import com.dhl.pages.LoginPage;

public class EmployeeTest extends AutomationWrapper {

	@Test
	public void addValidEmployeeTest()
	{
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("Admin");
		loginPage.enterPassword("admin123");
		loginPage.clickOnLogin();

		//MainPage
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		
//		PIMPage
		//click on add employee
		
		//Add under AddEmployeePage
		//enter firstname,middlename,lastname
		//upload some image
		//click on save
		
		//PersonalDetailsPage
		//assert the profile name shown
		
		
	}

}
