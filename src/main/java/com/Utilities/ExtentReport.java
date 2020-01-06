package com.Utilities;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	
	@Test
	
	public void reports() {
		
		System.out.println("hey i am using generating reports");
		//start reporters
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/sampel_report.html");
		//create ExtentReports attach reporter(s)
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);//ExtentHtmlReporter reference
		ExtentTest logger= extent.createTest("reports");//testmethodname
		logger.log(Status.INFO, "jdlksdkfjdsf");//status,markup
		logger.log(Status.PASS, "Title verified")            ;//status,markup
		extent.flush();
		ExtentTest logger2= extent.createTest("reports");//testmethodname
		logger2.log(Status.FAIL, "jdlksdkfjdsf");//status,markup
		//logger.fail("provider",MediaEntityBuilder                 //createScreenCaptureFromPath(//C:\\Users\\User\\eclipse-workspace\\FlightReservation\\FlightReservation\\ScreenshotsTakenFlightDetails1.png")//details and jpg file path
		
		extent.flush();
		//logger.addScreenCapturFromPath(imagePath)
	}

}
