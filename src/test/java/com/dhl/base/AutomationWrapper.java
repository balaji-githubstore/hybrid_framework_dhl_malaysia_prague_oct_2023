package com.dhl.base;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationWrapper {

	protected WebDriver driver;
	private static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void init()
	{
		if(extent==null)
		{
			extent = new ExtentReports();
			String fileName="Spark_"+LocalDateTime.now().toString().replace(":", "")+".html";
			
			ExtentSparkReporter spark = new ExtentSparkReporter("target/"+fileName);
			extent.attachReporter(spark);
		}	
	}

	@AfterSuite
	public void end()
	{
		extent.flush();
	}
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser" })
	public void setup(@Optional("ch") String browserName,Method mtd) {
		
		 test= extent.createTest(mtd.getName());

		if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void teardown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			
			TakesScreenshot ts=(TakesScreenshot) driver;
			test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
			
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}

		
		
		driver.quit();
	}
}
