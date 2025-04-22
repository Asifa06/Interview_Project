package Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Featurefiles/LoginFeature.feature", glue = { "stepDefinitions",
    "hooks" }, plugin = {
        "pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm" }, monochrome = true, tags = "@UI_Test")

public class TestRunner {
  


}
