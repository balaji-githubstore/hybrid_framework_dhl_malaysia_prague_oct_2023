package com.dhl.utils;

import org.testng.annotations.DataProvider;
/*
 * This class will have all the dataprovider details for the test method
 */
public class DataUtils {
	
	@DataProvider
	public String[][] invalidLoginData()
	{
		String[][] data=new String[2][3];
		
		data[0][0]="john";
		data[0][1]="john123";
		data[0][2]="Invalid credentials";
		
		data[1][0]="peter";
		data[1][1]="peter123";
		data[1][2]="Invalid credentials";
		
		return data;		
	}

}
