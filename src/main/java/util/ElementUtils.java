package util;



import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils
{
	WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickonWebElement(WebElement element,long durationInSeconds)
	{
		
		WebElement webelement = waitForElement(element,durationInSeconds);
		webelement.click();
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds)
	{
		WebElement webelement = waitForElement(element,durationInSeconds);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeTyped);
	}
	
	public void selecctOptionInDropdown(WebElement element,String dropDown,long durationInSeconds)
	{
		WebElement webelement=waitForElement(element,durationInSeconds);
		Select select=new Select(webelement);
		select.selectByVisibleText(dropDown);
	}

	public WebElement waitForElement(WebElement element,long durationInSeconds)
	{
		WebElement webelement=null;
		try {
		WebDriverWait wait =new WebDriverWait(driver, durationInSeconds);
		 webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	return webelement;
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitForalert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForalert(durationInSeconds);
		alert.dismiss();
	}
	
	public Alert waitForalert(long durationInSeconds)
	{
		Alert alert = null;
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,durationInSeconds);
		alert=wait.until(ExpectedConditions.alertIsPresent());
	    }
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return alert;
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds)
	{
		
		WebElement webelement=visibilityofElement(element,durationInSeconds);
		
		Actions action=new Actions(driver);
		action.moveToElement(webelement).click().build().perform();
	}
	
	public WebElement visibilityofElement(WebElement element,long durationInSeconds)
	{
		WebElement webelement = null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,durationInSeconds);
	webelement=wait.until(ExpectedConditions.visibilityOf(element));
	}
		
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		return webelement;
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds)
	{
		WebElement webelement=visibilityofElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].click();",webelement);
	}
	
	public void javaScripttobeTyped(WebElement element,long durationInSeconds,String tobeTyped)
	{
		WebElement webelement=visibilityofElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("argument[0].vlaue='"+tobeTyped+"'",webelement);
	}
	
	public String getTextFromeWebElement(WebElement element,long durationInSeconds)
	{
		WebElement webelement = waitForElement(element,durationInSeconds);
		return webelement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds)
	{
		try {
		WebElement webelement=visibilityofElement(element,durationInSeconds);
		return webelement.isDisplayed();
	}catch(Throwable e)
		{
		return false;
		}
		
		
	}
}
