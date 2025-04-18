package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {

    WebDriver driver;

    // Code to navigate to the login page

    public void the_user_is_on_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://8000-asifa06-interviewtest04-49qcjt0qba9.ws-eu118.gitpod.io/");
    }

    // Code to enter valid credentials
    public void the_user_enters_valid_credentials() {
        System.out.println("User enters valid credentials");
    }

    // Code to verify redirection to the dashboard
    public void the_user_should_be_redirected_to_the_dashboard() {
        System.out.println("User is redirected to the dashboard");
    }
}