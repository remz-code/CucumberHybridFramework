package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Commonutils;
import util.ElementUtils;

public class SearchPage
{
	WebDriver driver;
	private ElementUtils elementutils;
	
public SearchPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	elementutils=new ElementUtils(driver);
}




@FindBy(linkText="HP LP3065")
private WebElement productDisplayAlert;

@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
private  WebElement invalidProductDisplayAlert;




public boolean validProductdisplay()
{
	return elementutils.displayStatusOfElement(productDisplayAlert,Commonutils.EXPLICIT_WAIT_TIME);
	
}

public String InvalidproductDisplayMessage()
{
	return elementutils.getTextFromeWebElement(invalidProductDisplayAlert,Commonutils.EXPLICIT_WAIT_TIME);
	
}
}
