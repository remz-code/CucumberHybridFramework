package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Commonutils;
import util.ElementUtils;

public class AccountPage 
{

	WebDriver driver;
	private ElementUtils elementutils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(partialLinkText="Edit your account information")
	private WebElement editYouraccountInformation;
	
	public boolean editYourAccount()
	{
		return elementutils.displayStatusOfElement(editYouraccountInformation,Commonutils.EXPLICIT_WAIT_TIME);
	
		
	}
	
}
