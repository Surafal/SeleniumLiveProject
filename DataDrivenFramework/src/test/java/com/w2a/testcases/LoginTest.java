package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class LoginTest extends TestBase {
	
	//driver initialized in the test case so we have to extends the testbase file 
	
	
	@Test 
	public void loginAsBankManager() throws InterruptedException {
		
		
		log.debug("Inisde Login Test");
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(3000);
		
		log.debug(" Login Test is successful ");
		
		//vallidation to make sure the login back login and check the add custom button is there 
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))), "Login is not successful ");
		
	}
	
	
	@AfterSuite 
	public void tearDown() {
		
		//if driver not null then driver quite 
		if(driver!=null) {
		driver.quit();
		
		}
		
	}

}
