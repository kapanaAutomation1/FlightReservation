package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshots {


	 public static void captureScreenshot(WebDriver driver,String screenshotName)throws Exception 
   {
	      TakesScreenshot scrShot =((TakesScreenshot)driver);
	        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
try{
	     // FileUtils.copyFile(SrcFile,new File("C:\\Users\\User\\eclipse-workspace\\FlightReservation\\FlightReservation\\ScreenshotsTaken"
	        //   +"ScreenshotsTaken/TestCaseFailed.png"));
	     // FileUtils.copyFile(SrcFile,new File("./ScreenshotsTaken/"+screenshotName+".png"));
	FileHandler.copy(srcFile,new File("./Screenshots/"+screenshotName+".png"));                   
               System.out.println("ScreenshotsTaken");
              //driver.quit();
	     }catch(IOException e){
	    	 //e.printStackTrace();
	    	 System.out.println("Exception while taking screen shot"+e.getMessage());
	    	
	     }
	
	
    }
}