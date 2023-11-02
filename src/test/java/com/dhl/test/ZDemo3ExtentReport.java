package com.dhl.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ZDemo3ExtentReport {

	public static void main(String[] args) {
		
		//@BeforeSuite
		//report initialization - should run once in the beginning
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		//before the @Test method - @BeforeMethod
		ExtentTest test= extent.createTest("MyFirstTest-hhhhhh");
		
		
		test.info("hello clicked on login");
		
		
		//after the @Test method - @AfterMethod
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");
		
		
		//report generation - should run once in the end
		//@AfterSuite
		extent.flush();

	}

}
