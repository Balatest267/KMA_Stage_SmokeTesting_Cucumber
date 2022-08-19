package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
				
		features = "./src/test/java/feature/ProdSmokeTesting.feature",    
		
		
		glue = {"stepDefinitions"}, 
		plugin = {"pretty", "html:test-output","json:json_output/prodsmkcum.json", "junit:xml_output/prodsmkcum.xml",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
			
		monochrome = true
		
		//features - //Path of the feature file 
		//glue - path of the step definition 
		//tags - what tags in the feature file should be executed
		//monochrome - true - display the console output in much readable way
		//format - what all report formats to use
		//dryRun = false     //To check if all the steps have the step definition
		//strict = true//   //will fail execution if there are undefined or pending steps 
		)


public class ProdSmokeTestingTestRunner {
	
	 @AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File("./properties/extent-config.xml"));
	 
	 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
     Reporter.setSystemInfo("Machine", "Windows 7" + "64 Bit");
     Reporter.setSystemInfo("Selenium", "2.53.1");
     Reporter.setSystemInfo("Maven", "3.6.3");
     Reporter.setSystemInfo("Java Version", "1.8.0_231");
	  
	 }
	
}