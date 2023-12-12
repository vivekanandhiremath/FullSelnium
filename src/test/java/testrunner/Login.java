package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/Home.feature", glue = "steps"
        , tags = "@LoginToAccount", plugin = {"pretty", "html:src/Report/report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)
public class Login extends AbstractTestNGCucumberTests {
}
