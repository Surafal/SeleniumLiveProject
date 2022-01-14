package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
	
	
	           public static void main(String[] args) throws IOException {
				
	        	   System.out.print( System.getProperty("user.dir"));
	        	   
	        	  //import properities  to load the config properities files inside teh file inputstream 
	        	   Properties config = new Properties();
	        	   
	        	   Properties OR = new Properties();
	        	   
	        	   //for the config.properties
	        	   FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties"); 
	        	  config.load(fis);
	        	  
	        	  //for the OR.properities
	        	  fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties"); 
	        	  OR.load(fis);
	        	   
	        	  
	        	  
	        	//  driver.findElement(By.cssSelecton(OR.getProperty("bmlBTN"))).click();
	        	   System.out.println(config.getProperty("browser" ));
	        	   System.out.println(OR.getProperty("bmlBtn" ));
	        	   
	        	   
			}

}
