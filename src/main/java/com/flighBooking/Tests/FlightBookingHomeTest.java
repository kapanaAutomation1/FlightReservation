package com.flighBooking.Tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utilities.CaptureScreenshots;
import com.flightBooking.Pages.FlightBookingHomePage;
public class FlightBookingHomeTest {
	
	WebDriver driver;
	FlightBookingHomeTest sshp;
	
	
	  @BeforeTest
		public void setup(){
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();

		    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		   // driver.manage().window().fullscreen();          
		    driver.get(driver.getCurrentUrl());

		       driver.get("https://www.booking.com");
		   
		      
		}
	  @Test
	  public void flightsReservationTest() throws Exception {
		  
		
		  FlightBookingHomePage sshp=new FlightBookingHomePage(driver);
		  
		  sshp.viewAvailableFlights();
		  
		  sshp.choosingFlights();
		  
		  
		  sshp.selectDepatureLocation("DUB"); 
		  
		  CaptureScreenshots.captureScreenshot(driver, "DublinAirport0");
		  
		  sshp.selectTravelToLocation("LHR");
		//  driver.get(driver.getCurrentUrl());
		  
		  sshp.clickOnDatePicker();
		  
		  sshp.coosingTravelDate("January 2020","Jan 20");
		 
		 // sshp.datePicker();
		 sshp.selectingpeopleForTraveling(); 
		  CaptureScreenshots.captureScreenshot(driver, "TravelDate0");
		 sshp.addingTravelers();
		 sshp.searchFlightDetails();
		 Thread.sleep(1000);
		  CaptureScreenshots.captureScreenshot(driver, "FlightDetails0");
		  //driver.quit();
	  }
}
