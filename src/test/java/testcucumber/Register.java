package testcucumber;


import org.openqa.selenium.WebDriver;

import java.util.Map;

import org.junit.Assert;

import driver.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccesPage;
import pages.HomePage;
import pages.RegisterPage;
import util.Commonutils;

public class Register
{
	WebDriver driver;
	static RegisterPage registerpage;
	AccountSuccesPage accountpage;
	@Given("User Navigate to Register Page")
	public void user_Navigate_to_Register_Page()
	{
		
		driver=Driverfactory.getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.clickonMyAccount();
		registerpage=homepage.clickregisterButton();
		
	}
	@When("User Enters below details to fields")
	public void user_enters_below_details_to_fields(DataTable dataTable )
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(map.get("firstname"));
		registerpage.enterLastName(map.get("lastname"));
		Commonutils commonutils=new Commonutils();
		registerpage.enterEmailAddress(commonutils.getEmailwithTimeStamp());
		registerpage.enterTelephonNumber(map.get("telephone"));
		registerpage.enterPassword(map.get("password"));
		registerpage.cofirmPassword(map.get("password"));
		
		
	}
	

	@And("Select Privacy Policy Field")
	public void select_Privacy_Policy_Field()
	{
		
		registerpage.agreePrivacyPolicy();
		
	}
	
	@And("Click on continue button")
	public void click_on_continue_button()
	{
		
		accountpage=registerpage.clickonContinueButton();
		
	}
	
	@Then("Account should successfully created")
	public void account_should_successfully_created()
	{
		
	    Assert.assertEquals("Your Account Has Been Created!",accountpage.accountSuccesAlert());
	}
	@When("Select Yes for Newsletter")
	public void select_yes_for_newsletter() 
	{
		
		registerpage.newsletterSubscription();
	    
	}
	@When("User Enters the  below details to fields")
	public void user_enters_belowdetails_to_fields_sameEmail(DataTable dataTable )
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		registerpage.enterFirstName(map.get("firstname"));
		registerpage.enterLastName(map.get("lastname"));
		registerpage.enterEmailAddress(map.get("email"));
		registerpage.enterTelephonNumber(map.get("telephone"));
		registerpage.enterPassword(map.get("password"));
		registerpage.cofirmPassword(map.get("password"));
		
		
	}
	
	
	@When("User not providing any details to the fields")
	public void user_not_providing_any_details_to_the_fields()
	{
	  RegisterPage registerpage=new RegisterPage(driver);
	}
	@Then("Warning messages should be displayed for all mandatory fields")
	public void warning_messages_should_be_displayed_for_all_mandatory_fields() 
	{
		
		
		Assert.assertTrue(registerpage.privacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.firstNameWarningMessageAlert());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.lastNameWarningMessageAlert());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.emailWarningMessageAlert());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.telephoneWarningMessageAlert());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerpage.passwordWarningMessageAlert());
		
	}
	@Then("Warning messgae indicating that duplicate email should be displayed")
	public void warning_messgae_indicating_that_duplicate_email_should_be_displayed() 
	{
		Assert.assertTrue(registerpage.duplicateWarningMessageAlert().contains("Warning: E-Mail Address is already registered!"));
	}
	
}
