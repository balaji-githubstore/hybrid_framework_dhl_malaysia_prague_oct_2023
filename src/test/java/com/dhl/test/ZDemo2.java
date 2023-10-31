package com.dhl.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2 {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("test_data/OrangeData.xlsx");

		XSSFWorkbook book = new XSSFWorkbook(file);

		XSSFSheet sheet = book.getSheet("invalidLoginTest");

		
//		String[][] data=new String[2][3];
		
		//write a logic to print all cell values
		for(int r=1;r<3;r++)
		{
			for(int c=0;c<3;c++)
			{
				String cellValue = sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(cellValue);
//				data[0][0]=cellValue;
			}
		}
	}

}
