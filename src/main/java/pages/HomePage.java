package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.ElementUtils;

public class HomePage
{

	WebDriver driver;
	private ElementUtils elementutils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginButton;
	
	@FindBy(linkText="Register")
	private WebElement registerButton;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement validProductName;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement InvalidProductName;

	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private WebElement searchButton;

	
	public void clickonMyAccount()
	{
		elementutils.clickonWebElement(myAccountDropMenu, 15);
	}
	
	public LoginPage clickloginButton()
	{
		elementutils.clickonWebElement(loginButton, 30);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickregisterButton()
	{
		elementutils.clickonWebElement(registerButton, 30);
		return new RegisterPage(driver);
	}
	public void enterValidProductName(String productname)
	{
		elementutils.typeTextIntoElement(validProductName, productname,30);
		
	}
	public void enterInValidProductName(String productname)
	{
		elementutils.typeTextIntoElement(InvalidProductName, productname,30);
		
	}

	public SearchPage clickonSearchButton()
	{
		elementutils.clickonWebElement(searchButton,30);
		return new SearchPage(driver);
	}
}
