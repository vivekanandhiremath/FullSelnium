package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Home.feature", glue = "steps"
        , tags = "@RegisterAccount", plugin = "html:src/Report/report.html")
public class Register extends AbstractTestNGCucumberTests {
}
