package stepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        // Initialize the WebDriver here
        // Example: launch the browser
        LoginPage.driver = LoginPage.initialize_driver();
        System.out.println("Driver launched before each test");
    }

    @After
    public void tearDown() {
        // Quit the WebDriver here
    	
        if (LoginPage.driver != null) {
        	LoginPage.driver.quit();
            System.out.println("Driver closed after each test");
        }
    }
}
