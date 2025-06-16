package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Commonutils;
import util.ElementUtils;

public class AccountSuccesPage 
{
  WebDriver driver;
  private ElementUtils elementutils;
	public AccountSuccesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement accountSucesscreationMessgae;
	
	public String accountSuccesAlert()
	{
		return elementutils.getTextFromeWebElement(accountSucesscreationMessgae,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
}
