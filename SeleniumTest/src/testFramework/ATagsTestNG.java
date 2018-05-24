package testFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATagsTestNG {
	
	WebDriver driver;
	String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
    boolean createAccountPresent = false;
	
  @Test
  public void ATagsPresentTest() 
  {
	driver.get(webUrl);
	
	List <WebElement> aElements = driver.findElements(By.tagName("a"));
	int numOfATags = aElements.size();
	System.out.println("There are " + numOfATags +" a tags in the oage");
	
	for (WebElement aElement : aElements )
	{
		System.out.println(aElement.getText());
		if(aElement.getText().equals("CREATE ACCOUNT"))
		{
			createAccountPresent = true;
			break;
		}
	}
	
	Assert.assertTrue(createAccountPresent);
  }
  
  @BeforeMethod
  public void setUp()
  {
	  driver = utilities.WebdriverFactory.Open("chrome");
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.close();
  }
  
  
}
