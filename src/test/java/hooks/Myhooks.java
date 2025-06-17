package hooks;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import driver.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.Configreader;

public class Myhooks 
{
	WebDriver driver;
	@Before
	  public void setup() throws IOException, InterruptedException
	  {
		 Configreader configreader=new Configreader();
		  Properties prop=configreader.intializeProperties();
		  System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver.exe");
	      //WebDriver driver =  new ChromeDriver();
		 
		  driver=Driverfactory.InitializeBrowser(prop.getProperty("browserName"));
		  driver.get(prop.getProperty("url"));	  
	 
	  }
	  @After
	  public void  teardown(Scenario scenario)
	  {
		  String scenarioName=scenario.getName().replace(" ","_");
		  if(scenario.isFailed())
		  {
			byte[] screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png", scenarioName);
		  }
		  
		  driver.quit();
	  }
}
