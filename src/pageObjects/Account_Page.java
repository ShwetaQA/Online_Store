package pageObjects;

import org.openqa.selenium.WebDriver;

public class Account_Page {

	//private static WebElement element = null;
	
	

	public static void btn_LogOut(WebDriver driver)throws Exception
	{
		// TODO Auto-generated method stub
		Home_Page.lnk_LogOut(driver).click();
	}
	
}
