
package com.flightBooking.Pages;


import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
	
	public class FlightBookingHomePage {
		
		WebDriver driver;
		
		 @FindBy(xpath="//div[@id=\"cross-product-bar\"]//a[1]/span[2]")
		  WebElement flights;
	      
		 @FindBy(xpath="//*[@class=\"css-ugczlf-inputContainer\"]//input[@type=\"text\" and @ placeholder=\"Where from?\"]")
		 WebElement fromDeparture;
		// @FindAll({@FindBy(xpath="//input[@type='text' and @class='css-o331od' and @placeholder='Where from?']")})
	     //List<WebElement> searchLocation;
		 @FindBy(xpath="//input[@type='text' and @class=\"css-o331od\" and @placeholder='Where from?']")
		 WebElement whereFromSearch;
	
	  @FindBy(xpath="//*[@class=\"css-ugczlf-inputContainer\"]//input[@type=\"text\" and @ placeholder=\"Where to?\"]")
	  WebElement toArrival;
	  
	  @FindBy(xpath="//input[@type='text' and @class=\"css-o331od\" and @placeholder='Where to?']")
	  WebElement whereToSearch;
	    
			 @FindBy(xpath="//*[@class=\"css-vrzdvd-SearchboxInput\" and @placeholder=\"When?\"]")
			  WebElement travelDate;
			 
			// @FindBy (xpath="//*[@type=\"text\" and @class=\"css-vrzdvd-SearchboxInput\" and @readonly value=\"1 adult\"]")
			 @FindBy (xpath="//*[@class=\"css-vrzdvd-SearchboxInput\" and @value=\"1 adult\" ]")
			        WebElement travelingPassengers;
			 @FindBy (xpath="//*[@ class=\"css-1vzgvp0\"]")
	             WebElement addPassengers;
			
			@FindBy(xpath="//*[@class=\"css-bzt01u\" and contains(text(),'Done')]")
			  WebElement doneButton;
			@FindBy (xpath="//button[contains(text(),\"Search\")]")
			      WebElement  searchFlight;
	 /* 
	 * @FindBy(css="#depart-fsc-datepicker-button") WebElement departureDate;
	 * 
	 * @FindBy(
	 * xpath="//div[@class='BpkCalendarGrid_bpkcalendar-grid__sak14 FlightDatepicker_fsc-datepicker__list-size__1UX2a']//tr[@claclass=css-1tind10 selectedss='bpk-calendar-grid__week']"
	 * +
	 * "//td[@class='BpkCalendarGrid_bpk-calendar-grid__date__1uO4Y']//button[@lass='BpkCalendarDate_bpk-calendar-date__MuPBz BpkCalendarDate_bpk-calendar-date--focused__1Q1xo BpkCalendarDate_bpk-calendar-date--selected__1Hjrd' and @area-label='Tuesday, 28 January 2020'//span[@text(),'28/01/2020']"
	 * ) WebElement dateWidget;
	 */
	 
	 public FlightBookingHomePage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	 
	    public void viewAvailableFlights() {
	    	
	    	flights.click();
	    	

	    }
	    	
	public void choosingFlights() {
		
	//	Actions ac=new Actions(driver);
//		ac.doubleClick(fromDeparture);
		fromDeparture.click();
		
	}
      
    	  public void setFrom(String fromLocation) {
    		  
    	       whereFromSearch.sendKeys(fromLocation);
      }

    	  public void setTo(String toLocation) {
    		  boolean staleElement = true; 

    		  while(staleElement){
    		  
    		  try {
     			  
    		    	 
    		  whereToSearch.sendKeys(toLocation);
    		  staleElement = false;
    		  }
    		  catch(StaleElementReferenceException e) {
    			  driver.findElement(By.xpath("//input[@type='text' and @class=\"css-o331od\" and @placeholder='Where to?']")); 
  
    			  whereToSearch.sendKeys(toLocation);
    			  staleElement = true;
    			  
    		  }
     }}
    	  
    
          public void selectDepatureLocation(String departureLocation) throws IOException{

              //Fill FROM Location
    System.out.println(departureLocation);
              this.setFrom(departureLocation);
              
             
             // List<WebElement> cityoptions =  driver.findElements(By.xpath("//*[@class=\"css-195v96g-autocompleteResults\"]//li/div[@class=\"css-chwtq2\"]//div[@class=\"css-bwf4ll\"]//div[1]"));
              WebElement city =  driver.findElement(By.xpath("//*[@class=\"css-195v96g-autocompleteResults\"]//li/div[@class=\"css-chwtq2\"]//div[@class=\"css-bwf4ll\"]//div[1]"));

              //for (WebElement city : cityoptions) {don't Initialise the list type webElement if it is direct to single element then we got stake element exception
            	 System.out.println(city);
                 // if (city.getText().equalsIgnoreCase("Dublin Airport"))
                      city.click();
              }
              
        //  }
          
          public void selectTravelToLocation(String arrivalLocation) { 
        	  //Fill To Location
              this.setTo(arrivalLocation);

              System.out.println(arrivalLocation);

             WebElement arrivalCity =  driver.findElement(By.xpath("//*[@class=\"css-195v96g-autocompleteResults\"]//li[@class=\"css-6ezpeb\"]//div[@class=\"css-bwf4ll\"]//div[1]"));
              System.out.println(arrivalCity);
                 
                      arrivalCity.click();

          }
          
	
          public void clickOnDatePicker() throws InterruptedException {
        	 
        	  WebDriverWait wait = new WebDriverWait(driver, 20);
        	  wait.until(ExpectedConditions.visibilityOf( travelDate));
        	 // travelDate.click();
        	  
        	  
        	  Actions actions = new Actions(driver);
        	 actions.moveToElement(travelDate).doubleClick().perform();
        	 
          }
             public void coosingTravelDate(String monthYear, String day1) throws InterruptedException {
        	  
        	 List<WebElement> monthOptions =driver.findElements(By.xpath("//*[@class=\"css-8xr1zk\"]//div[@class=\"DayPicker-Caption\"]//*"));
        	 // List<WebElement> monthOptions =driver.findElements(By.xpath("//div[@class=\"DayPicker-Body\"]"));
        	  System.out.println("select month "+monthOptions.size());
          for (WebElement selectMonth :monthOptions ) 
        	  {
               	    System.out.println("select month "+selectMonth.getText());
                     
					   if (selectMonth.getText().equalsIgnoreCase(monthYear)) 
					    {
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();", selectMonth);
             			Thread.sleep(5000);
             			
      		
             		   // List<WebElement>monthDays =driver.findElements(By.xpath("//div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Week\"]//div[contains(@aria-label,\"Jan\")]"));
        	   // WebElement date=selectMonth.findElement(By.xpath("//div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Week\"]//div[@role=\"gridcell\" and contains(@aria-label,\"Jan 17\")]"));
             			
             		//String day1="Jan 17";
             		WebElement date =driver.findElement(By.xpath("//div[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Week\"]//div[@role=\"gridcell\" and contains(@aria-label,\'"+day1+"')]"));             			
             		  WebDriverWait wait = new WebDriverWait(driver, 20);
               	    	wait.until(ExpectedConditions.visibilityOf(date));
               	    	
               		  Actions actions = new Actions(driver);
               	    	actions.moveToElement(date).click().doubleClick().perform();
               	    	System.out.println("Given date has been selected"+day1);
               	    	break;
					    }//end of if
					   
        	    }//end of for loop
          }//  end of method
          public void selectingpeopleForTraveling() throws InterruptedException {
         
        	  WebDriverWait wait = new WebDriverWait(driver, 10);

        	  wait.until(ExpectedConditions.visibilityOf(travelingPassengers ));
        	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("css-1v575k2")));//handling unknown error the other element to be clickable
        			  
         	JavascriptExecutor executor = (JavascriptExecutor)driver;
         	executor.executeScript("arguments[0].click();",   travelingPassengers);
         	
         	Assert.assertTrue(travelingPassengers.isDisplayed());
         	 

         	travelingPassengers.click();
         	 
        }
        	  
         
          public void addingTravelers() {
        	  
        	
        		  int adult = 1;
        		  int child = 2;
        		  
        		 List <WebElement>adultsandchild =driver.findElements(By.xpath("//*[@ class=\"css-1vzgvp0\"]"));
 	               int additions=adultsandchild.size();
 	              // System.out.println("additions Size : "+additions);
         	      for (int i=0;i<=additions;i++) {
         	    	  
         	    	  if(i==0) {
         	    		  for(int b=0;b<adult;b++) 
         	    		  {
         	    			 WebElement alds =adultsandchild.get(i);
         	    	    alds.click();
         	    		
         	    	    System.out.println("adults are being selected");
         	    		  }	}
         	    	  if(i==1) {
         	
         	    	 for(int a=1;a<=child;a++) 
         	    	 {  WebElement kids=adultsandchild.get(i);
         	    		
        	         	 kids.click(); 
        	
             	     System.out.println("child's are being selected");}  }
         	     }
         	      
         	      
         	    // List<WebElement> selectAge= driver.findElements(By.xpath("//*[@ class=\"css-1p8qfr9\" and contains(text(),\"Select age\")]"));
         	    List<WebElement> selectAge= driver.findElements(By.xpath ("//*[@ class=\"css-5ea88r\"]"));
         	    	 
             	  int childAgeSize =selectAge.size();
         	    for(int s=0;s<=childAgeSize ;s++) 
         	    	{if(s==0){
    	    	  WebElement childAge =selectAge.get(s);
           	          Select selectingAge =new Select(childAge);
           	        	  selectingAge.selectByValue("12");
         	    	}
            	 
         	   if(s==1){
         	     WebElement childAge =selectAge.get(s);
    	          Select selectingAge =new Select(childAge);
    	        	  selectingAge.selectByValue("7");
     	       }}//end of for loop
        	  doneButton.click();
         	    	  }//end of method
         	    	  
         	    	
                	      //System.out.println("NumberOfPassingers" +addpassingers.get(i).getText());
                	      //if( addpassingers.get(i).getText().equals("2")) 
 	                
        		  
        
        	  public void searchFlightDetails() {
        		  
        		  searchFlight.click();
        	  }
        	  
        	  
          }//end of class
          
          
	
 //end of class