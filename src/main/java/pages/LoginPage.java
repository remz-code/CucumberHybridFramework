package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Commonutils;
import util.ElementUtils;

public class LoginPage 

{
	public WebDriver driver;
	private ElementUtils elementutils;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement emailTextField;
	
	@FindBy(name="password")
	private WebElement passwordTextField;
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAddressNotFoundAlert;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement properMessageforInvalidLogin;
	
	public void enterEmailAddress(String emailText)
	{
		elementutils.typeTextIntoElement(emailTextField, emailText,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterPassword(String passwordText)
	{
		elementutils.typeTextIntoElement(passwordTextField, passwordText,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public AccountPage clickonLoginButton()
	{
		elementutils.clickonWebElement(loginButton,Commonutils.EXPLICIT_WAIT_TIME);
		return new AccountPage(driver);
	}
	
	public String alertForInvalidLogin()
	{
		return elementutils.getTextFromeWebElement(properMessageforInvalidLogin,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
}
