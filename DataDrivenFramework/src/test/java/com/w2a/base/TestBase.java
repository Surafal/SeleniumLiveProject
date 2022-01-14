package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.utilities.ExcelReader;

public class TestBase {

/*
 * WebDriver - initilization of webdriver  - done 
 * Properties - initilization of properities  - done 
 * Logs - added log4j jar file - we added using the pom.xml , .log,  log4j.properties(under logs and - file is located under utilities) , logger(skipped) 
 * 
 * ExtentReports
 * DB
 * Excel 
 * Mail 
 * ReportNG, ExtentReports 
 * Jenkins
 * 
 */

public static WebDriver driver;
public static Properties config = new Properties();
public static Properties OR = new Properties();
public static FileInputStream fis;
public static Logger log = Logger.getLogger("devpinoyLogger");
public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\DataDrivenData.xlsx");

public static WebDriverWait wait; 




//explicit wait and implicit wait difference  **************
	
	@BeforeSuite
	public void setUP() {
		if(driver ==null) {
			
			
			//for the config.properties
     	 
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     	  try {
			config.load(fis);
			log.debug("Configi file loaded !!!! ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	  
     	  //for the OR.properities
     	  try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			log.debug("Configi file loaded !!!! ");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     	  try {
			OR.load(fis);
			log.debug("Configi file loaded !!!! ");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
     	  
     	  if(config.getProperty("browser").equals("firefox")){
     		  
     		  //latest gicko driver  
     		  //System.setProperty("webdriver.gecko.driver", "gecko.exe");
     		  driver = new FirefoxDriver();
     		 log.debug("fireFox is lanuached !!!! ");
     		  
     	  }else if(config.getProperty("browser").equals("chrome")){
     		  
     		  //latest gicko driver  
     		  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
     		  driver = new ChromeDriver();
     		 log.debug("Chrome is lanuched !!!! ");
     		  
     	  }
     	  
				
		}else if(config.getProperty("browser").equals("edge")){
   		  
   		  //latest gicko driver  
   		  System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\msedgedriver.exe");
   		  driver = new EdgeDriver();
   		log.debug("Edge is lunched !!!! ");
   		  
   	  }
		
		
		
	  driver.get(config.getProperty("testsiteurl"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	  wait = new  WebDriverWait (driver, 5 );
		
	}
	
	
	
	
	public boolean isElementPresent(By by ) {
		
		try {
			
			driver.findElement(by);
			return true;
			
			
		} catch(NoSuchElementException e ) {
			
			return false ;
		}
		
	}
	
	
	@AfterSuite
	public void tearDown(){
		
		if(driver!=null) {
			
			driver.quit();
		}
		
		
		log.debug("Test execution completed");
	}
	
	
	
	
	
	
	
	
}
