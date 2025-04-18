package Runners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/Featurefiles",
  glue = "stepDefinitions",
  plugin = {"pretty", "html:target/cucumber-report.html"},
  monochrome = true,
  tags="@Tc_Login_001"
)
public class TestRunner {

  public static void main(String[] args) {
    // Code to run the Cucumber tests
    System.out.println("Running Cucumber tests...");
}
    
}
