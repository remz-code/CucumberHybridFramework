package testcucumber;

import org.openqa.selenium.WebDriver;

import driver.Driverfactory;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import util.Commonutils;


public class Login
{
	 public static WebDriver driver;
	 private static LoginPage loginpage;
	 AccountPage accpage;
  
	@Given("^User navigate to Login page$")
	public static void user_navigate_to_login_page() 
	{ 
		
		 driver=Driverfactory.getDriver();
		 
		 HomePage homepage=new HomePage(driver);
		 homepage.clickonMyAccount();
         loginpage=homepage.clickloginButton();
        
     }

	@When("^Enter Valid email address (.+)$")
	public void enter_valid_email_address(String emailText) 
	{
		
		 loginpage.enterEmailAddress(emailText);

	}

	@And("^Enter Valid password (.+)$")
	public void enter_valid_password(String passwordText) 
	{
		 
		//loginpage=new LoginPage(driver);
		 loginpage.enterPassword(passwordText);
	}

	@And("^Click on Login  button$")
	public void c_lick_on_login_button()
	{
		
		//loginpage=new LoginPage(driver);
		accpage=loginpage.clickonLoginButton();
	

	}

	@Then("^Sucesfully logged the user$")
	public void sucesfully_logged_the_user() 
	{
		
         Assert.assertTrue(accpage.editYourAccount());
	}

	@When("Enter InValid email address")
	public void enter_invalid_email_address() 
		{
		Commonutils commonutils=new Commonutils();
		loginpage.enterEmailAddress(commonutils.getEmailwithTimeStamp());
		

	     }

	@And("^Enter InValid password \"(.+)\"$")
	public void enter_invalid_password(String passwordText) 
	{
		
		loginpage.enterPassword(passwordText);
		

	}
	
	@Then("Proper Warning message should displayed")
	public void proper_warning_message_should_displayed()
	{
		
		
		Assert.assertTrue(loginpage.alertForInvalidLogin().contains("Warning: No match for E-Mail Address and/or Password."));
	}


}
