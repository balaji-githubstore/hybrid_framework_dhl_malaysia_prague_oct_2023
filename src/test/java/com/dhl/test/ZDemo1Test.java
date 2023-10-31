package com.dhl.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
 * will be deleted
 */
public class ZDemo1Test {
	
	@DataProvider
	public String[][] demoData()
	{
		String[][] data=new String[3][2];
		
		data[0][0]="saul";
		data[0][1]="saul123";
		
		data[1][0]="kim";
		data[1][1]="kim123";
		
		data[2][0]="john";
		data[2][1]="john123";
		
		return data;
	}

	@Test(dataProvider = "demoData")
	public void validLoginDemoTest(String username,
			String password)
	{
		System.out.println("hello"+username+password);
	}
}
