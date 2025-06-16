package testcucumber;


import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import driver.Driverfactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

public class Search 
{
	WebDriver driver;
	SearchPage searchpage;
	HomePage homepage;
	@Given("User open the application")
	public void user_open_the_application() 
	{
		
	   driver=Driverfactory.getDriver();
	   System.out.print(driver);
	}
	@When("User enter the Valid Product in the Search field {string}")
	public void User_enter_the_Valid_Product_in_the_Search_field (String productName)
	{
		homepage=new HomePage(driver);
		homepage.enterValidProductName(productName);
		
	}

	@When("User enter the InValid Product in the Search field {string}")
	public void use_enter_the_invalid_product_in_the_search_field(String productName) 
	{
		homepage=new HomePage(driver);
		homepage.enterInValidProductName(productName);
		
	}

	@And("User Clicks on the Search button")
	public void user_clicks_on_the_search_button() 
	{
		//homepage=new HomePage(driver);
		searchpage=homepage.clickonSearchButton();
		
	}

	@Then("Valid product details is listed after searching")
	public void valid_product_details_is_listed_after_searching() 
	{
		
		Assert.assertTrue(searchpage.validProductdisplay());
	}
	

	@Then("Warning message should displayed about product display")
	public void warning_message_should_displayed_about_product_display() 
	{
		Assert.assertEquals("There is no product that matches the search criteria.",searchpage.InvalidproductDisplayMessage());
	}
	

	@When("User dont enter any product in the search field")
	public void use_dont_enter_any_product_in_the_search_field()
	{
		
		homepage=new HomePage(driver);
	}
	}




