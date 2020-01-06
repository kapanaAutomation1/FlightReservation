package TestNGListenerConcept;


	import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Base {
		
		 public static WebDriver driver; 
		  
		  
		  public void intialization() {
		  
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\User\\Documents\\chromedriver_win32\\chromedriver.exe"); 
		  driver =new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		  
		  driver.get(driver.getCurrentUrl());
		  
		  driver.get("https://www.booking.com"); }
		 

		 public void failedTCScreenshot(String screenshotName)throws Exception 
	   {
		      TakesScreenshot scrShot =((TakesScreenshot)driver);
		        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
	try{
		     // FileUtils.copyFile(SrcFile,new File("C:\\Users\\User\\eclipse-workspace\\FlightReservation\\FlightReservation\\ScreenshotsTaken"
		        //   +"ScreenshotsTaken/TestCaseFailed.png"));
		     // FileUtils.copyFile(SrcFile,new File("./ScreenshotsTaken/"+screenshotName+".png"));
		FileHandler.copy(srcFile,new File("./ScreenshotsTaken/"+screenshotName+".png"));                   //(SrcFile, screenshotName));
	               System.out.println("ScreenshotsTaken");
	              //driver.quit();
		     }catch(IOException e){
		    	 //e.printStackTrace();
		    	 System.out.println("Exception while taking screen shot"+e.getMessage());
		    	
		     }
		
		
	    }
	}


