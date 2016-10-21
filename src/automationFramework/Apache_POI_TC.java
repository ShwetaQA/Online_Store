package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import appModules.SignIn_Action;
import pageObjects.Account_Page;
import pageObjects.Home_Page;
//import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;

public class Apache_POI_TC extends ExcelUtils {
	
	WebDriver driver;
	//private static WebDriver driver = null;
	
	//public static void main(String[] args) throws Exception {
		
		@BeforeTest
	    @Parameters("browser")
		
	    public void setUp(String browser) throws Exception
		{
	        //Check if parameter passed from TestNG is 'firefox'

	        if(browser.equalsIgnoreCase("firefox"))
	        {
	        	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//BrowserDrivers//geckodriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
				//create firefox instance
				driver = new FirefoxDriver(capabilities); 
	        
	        }

	        //Check if parameter passed as 'chrome'

	        else if(browser.equalsIgnoreCase("chrome"))
	        {
	            //set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
	        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
	            
	            //create chrome instance

	            driver = new ChromeDriver();

	        }

	        else if(browser.equalsIgnoreCase("ie"))
	        {
	           	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//BrowserDrivers//IEDriverServer.exe");

	            //create chrome instance

	            driver = new InternetExplorerDriver();

	        }

	        else
	        {
	            //If no browser passed throw exception

	            throw new Exception("Browser is not correct");

	        }

	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    }
		
		
		@Test
	    public void testParameterWithXML() throws Exception{
	    	
	    	//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
	   
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		//capabilities.setCapability("marionette", true);
		//WebDriver driver = new FirefoxDriver(capabilities); 
		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		//driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(Constant.URL);
		
		System.out.println(driver);
		
		SignIn_Action.Execute(driver);
		
		System.out.println("Login Successfully, now it is the time to Log Off buddy.");
		
		Home_Page.lnk_LogOut(driver).click(); 
		
		//Account_Page.btn_LogOut(driver);
		
		SignIn_Action.Log_Out(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.close();
		
		//This is to send the PASS value to the Excel sheet in the result column.
		
		ExcelUtils.setCellData("Pass", 1, 3);
	
	    }

}
