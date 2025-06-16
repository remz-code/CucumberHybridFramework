package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Commonutils;
import util.ElementUtils;

public class RegisterPage 
{
    WebDriver driver;
    private ElementUtils elementutils;
    
    @FindBy(id="input-firstname")
    private WebElement firstNameText;
    
    @FindBy(id="input-lastname")
    private WebElement lastNameText;
    
    @FindBy(id="input-email")
    private WebElement emailAddressText;
    
    @FindBy(id="input-telephone")
    private WebElement telephoneText;
    
    @FindBy(id="input-password")
    private WebElement passwordText;
    
    @FindBy(id="input-confirm")
    private WebElement confirmpasswordText;
    
    
    @FindBy(xpath="//input[@name='agree']")
    private WebElement agreePolicy;
    
    @FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;
    
    @FindBy(xpath="//label[normalize-space()='Yes']//input[@name='newsletter']")
    private WebElement newsLetterField;
    
    @FindBy(css="#account-register > div.alert.alert-danger.alert-dismissible")
    private WebElement privaypolicyWaning;
    
    @FindBy(xpath="//*[@id=\\\"account\\\"]/div[2]/div/div")
    private WebElement firstNameWarningMessage;
    
    @FindBy(xpath="//*[@id=\\\"account\\\"]/div[3]/div/div")
    private WebElement lastNameWarningMessage;
    
    @FindBy(xpath="//*[@id=\\\"account\\\"]/div[4]/div/div")
    private WebElement emailWarningMessage;
    
    @FindBy(xpath="//*[@id=\"account\"]/div[5]/div/div")
    private WebElement telephoneWarningMessage;
    
    @FindBy(xpath="//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")
    private WebElement passwordWarningMessage;
    
    @FindBy(css="#account-register > div.alert.alert-danger.alert-dismissible")
    private WebElement duplicateEmailAlert;
    
	public RegisterPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		elementutils=new ElementUtils(driver);
	}
	
	public void enterFirstName(String firstName)
	{
		elementutils.typeTextIntoElement(firstNameText, firstName, Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	public void enterLastName(String lastName)
	{
		elementutils.typeTextIntoElement(lastNameText, lastName,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterEmailAddress(String email)
	{
		elementutils.typeTextIntoElement(emailAddressText, email,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterTelephonNumber(String telephone)
	{
		elementutils.typeTextIntoElement(telephoneText, telephone,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void enterPassword(String password)
	{
		elementutils.typeTextIntoElement(passwordText, password,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void cofirmPassword(String password)
	{
		elementutils.typeTextIntoElement(confirmpasswordText, password,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public void agreePrivacyPolicy()
	{
		elementutils.clickonWebElement(agreePolicy,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public AccountSuccesPage clickonContinueButton()
	{
		elementutils.clickonWebElement(continueButton,Commonutils.EXPLICIT_WAIT_TIME);
		return new AccountSuccesPage(driver);
	}
	
	public void newsletterSubscription()
	{
		elementutils.clickonWebElement(newsLetterField,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String privacyPolicyWarningMessage()
	{
		return elementutils.getTextFromeWebElement(privaypolicyWaning,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String firstNameWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(firstNameWarningMessage,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	public String lastNameWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(lastNameWarningMessage,Commonutils.EXPLICIT_WAIT_TIME);
	}
	public String emailWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(emailWarningMessage,Commonutils.EXPLICIT_WAIT_TIME);
	}
	
	public String telephoneWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(telephoneWarningMessage,Commonutils.EXPLICIT_WAIT_TIME);	
	}
	
	public String passwordWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(passwordWarningMessage,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
	
	public String duplicateWarningMessageAlert()
	{
		return elementutils.getTextFromeWebElement(duplicateEmailAlert,Commonutils.EXPLICIT_WAIT_TIME);
		
	}
}
