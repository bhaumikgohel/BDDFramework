package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\Automation\\FreeCRMBDDFramework\\src\\main\\java\\Features\\deal.feature",//Path of feature file
    glue = "stepDefinations", // name of step defination file
    plugin = {"pretty", "html:test-output","json:json_output/cucumber.json"},//Generate Different types of reports
    dryRun = false,// Check Feature and Stepdafination are proper
    publish = true,//publish report online
    tags="@End2End,@RegressionTest"
    ,monochrome = true //Console output displaying in readable form
   
    
)
public class TestRunner {

}
