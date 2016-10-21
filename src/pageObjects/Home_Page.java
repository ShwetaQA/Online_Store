package pageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	public static WebElement element = null;
	
	@Test
    public static WebElement lnk_MyAccount(WebDriver driver)
    {
    	
    	element = driver.findElement(By.id("account"));
	
		return element;
	
	}
	
	@Test
	 public static WebElement lnk_LogOut(WebDriver driver)
	 {
		// element = driver.findElement(By.id("account_logout"));
		 
		 element=driver.findElement(By.xpath(".//*[@id='account_logout']/a"));
	
		 return element;
	
	}
}
