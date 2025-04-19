package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Featurefiles/LoginFeature.feature", glue = { "stepDefinitions",
    "hooks" }, plugin = {
        "pretty", "html:target/cucumber-report.html" }, monochrome = true, tags = "@UI_Test")
public class TestRunner {

  public static void main(String[] args) {
    // Code to run the Cucumber tests
    System.out.println("Running Cucumber tests...");
  }

}
