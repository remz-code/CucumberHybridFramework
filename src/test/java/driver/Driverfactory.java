package driver;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import util.Commonutils;

public class Driverfactory {

	static WebDriver driver;
	public  static  WebDriver InitializeBrowser(String browserName) throws InterruptedException 
	{
		
		
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}

		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else if (browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Commonutils.PAGE_LOAD_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Commonutils.IMPICIT_WAIT_TIME, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	

}
