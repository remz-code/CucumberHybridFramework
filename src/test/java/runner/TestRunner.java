package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
                 glue={"testcucumber","hooks"}, 
                 tags="@all",
                 publish=true,
                 plugin= {"pretty",
                		 "html:target/CucumberReport/Cucumberhtmlreport.html",
                		
                		 } )
                  
public class TestRunner
{

}
