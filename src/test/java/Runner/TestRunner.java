package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\Automation\\FreeCRMBDDFramework\\src\\main\\java\\Features\\login.feature",
    glue = "stepDefinations",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {

}
