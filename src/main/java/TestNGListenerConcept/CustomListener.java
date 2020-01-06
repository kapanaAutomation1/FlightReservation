package TestNGListenerConcept;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends Base implements ITestListener{
         public void onTestStarts(ITestResult result)
		   { //TODo Auto-generated method stub 
		   }
	     public void onTestSuccess(ITestResult result) 
		     {System.out.println("TestCase Success Hurryyy and details are"+result.getName());
		      }

		 public void onTestFailure(ITestResult result) {
			   try {
		  System.out.println("Failed Test");
		  failedTCScreenshot("Screenshot1"); 
		   }catch(Exception e) {
			   }}
		  public void onTestSkipped(ITestResult result) 
		       { System.out.println("TestCase skipped and details are"+result.getName());
		       }
          public void onTestStart(ITestResult result)
			  { System.out.println("TestCase Started and details are"+result.getName());
				  }
		  public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
		      { //TODO Auto-generated method stub
			      }
		  public void onFinish(ITestContext context)
		        { //TODO Auto-generated method stub 
			    }
		 }
		 
	
