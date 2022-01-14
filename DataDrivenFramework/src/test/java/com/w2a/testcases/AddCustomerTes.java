package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTes extends TestBase {
	
	
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName , String postCode, String alerttext) throws InterruptedException {
		
		
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click(); 
		
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName); 
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click(); 
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); 
		
		Assert.assertTrue(alert.getText().contains(alerttext));
		Thread.sleep(3000);
		alert.accept();
		
		Thread.sleep(3000);
		
		
		//explicit wait 
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTes";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName); 
		
		Object[][] data = new Object[rows-1][cols];
		
		//starts from row number 2  and less or = 2 and tehn the column start from 0  run is less than  column count 
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			
			for (int colNum = 0; colNum < cols; colNum++) {
				
				//data[0][0]  - paramaterization in TestNG 
				
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum); 
				
			}
		}
		
		
		return data; 
		
		
		
	}
	

}
