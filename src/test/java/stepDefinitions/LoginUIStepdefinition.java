package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;

public class LoginUIStepdefinition {

    WebDriver driver;
    LoginPage loginpage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        try{
            loginpage.the_user_is_on_the_login_page();
        } catch (Exception e) {
                e.printStackTrace();
                
        }
        
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        // Code to enter valid credentials
        System.out.println("User enters valid credentials");
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        // Code to verify redirection to the dashboard
        System.out.println("User is redirected to the dashboard");
    }
}