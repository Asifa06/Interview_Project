
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", plugin = { "pretty",
        "html:target/cucumber-report.html" }, monochrome = true, tag = "@Tc_Login_001")
public class TestRunner {
    public static void main(String[] args) {
        // Code to run the Cucumber tests
        System.out.println("Running Cucumber tests...");
    }
}
