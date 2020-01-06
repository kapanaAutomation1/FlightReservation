package TestNGListenerConcept;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)//this is not recomended due to this is class level,add listener code in testng file
public class ScreenshotTest extends Base{
	@BeforeMethod
	public void setUp() {
	intialization();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test
public void takeScreenshotTest()
	{
		Assert.assertEquals(true,false);
	}
}
