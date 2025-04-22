package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;

public class LoginUIStepdefinition {

    WebDriver driver;
    LoginPage loginpage = new LoginPage();

    
    @Given("the user login with {string} credentials")
    public void the_user_enters_valid_credentials(String credentials) {
    	try {
    		loginpage.the_user_enters_valid_credentials(credentials);
    	}catch(Exception e) {
    		   Assert.fail("Fails while login with "+credentials+" password");

    	}
    }

    @Then("user update the password successfully")
    public void update_password() {
    	try {
    		loginpage.update_password();
    	}catch(Exception e) {
    		Assert.fail("Fails while updating the password");
    	}
 
    }
    
    @Then("logout from the application")
    
    public void logout() {
		try {
			loginpage.logout();
		}catch(Exception e) {
			Assert.fail("Fails while logging out from the application");
		}
	}
    
    @And ("validate the user is on the home page")
    public void validate_homepage() {
		try {
			loginpage.validate_homepage();
		}catch(Exception e) {
			Assert.fail("Fails while validating the home page");
		}
	}
	

	}
    
    