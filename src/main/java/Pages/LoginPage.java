package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.icu.impl.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Commonmethods;
import utility.encrypt_decrypt;



public class LoginPage {

    public static WebDriver driver;
//    public encrypt_decrypt ed = new encrypt_decrypt();
   String secretKey = encrypt_decrypt.secretKey;
   String encryptedPassword = Commonmethods.getCredential("Password");
	String encryptednewpassword = Commonmethods.getCredential("new_Password");
	String encryptedusername = Commonmethods.getCredential("Username");

	
	/**
     * Code to launch the browser and navigate to the login page
     * @return 
     */
	
    public static WebDriver initialize_driver() {
        try{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            
            
        }catch(Exception e){
            Assert.fail("Fails while launching the browser");
        }
		return driver;
        
    }
    
     /**
      * Code to enter valid credentials
      * @param credentials - valid/invalid/updated
      */
    public void the_user_enters_valid_credentials(String credentials) {
    	
     try {
    	 
    	 driver.get(Commonmethods.getCredential("APP_URL")); // Use environment variable
         driver.manage().window().maximize();
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Commonmethods.getLocator("loginPage","loginpagebutton"))));
    	 driver.findElement(Commonmethods.getLocator("loginPage","loginpagebutton")).click();
    	 Commonmethods.switchtowindow(driver,"Log in - Kmbal Movies");
    	 
    	 
    	 System.out.println(encryptedusername);
    	 System.out.println(encrypt_decrypt.decrypt(encryptedusername, secretKey));
    	 System.out.println(encryptedPassword);
    	 System.out.println(encrypt_decrypt.decrypt(encryptedPassword, secretKey));
    	 System.out.println(encryptednewpassword);
    	 System.out.println(encrypt_decrypt.decrypt(encryptednewpassword, secretKey));
    	 
    	 WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(Commonmethods.getLocator("loginPage","username")));
    	 usernameField.sendKeys(encrypt_decrypt.decrypt(encryptedusername, secretKey));
    	 //usernameField.sendKeys(Commonmethods.getCredential("Username"));
    	 WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(Commonmethods.getLocator("loginPage","password")));
    	 
    	 if(credentials.equalsIgnoreCase("valid")) {
    		 
    		 passwordField.sendKeys(encrypt_decrypt.decrypt(encryptedPassword, secretKey));
    		// passwordField.sendKeys(Commonmethods.getCredential("Password"));
    	
			 
		}else if(credentials.equalsIgnoreCase("updated")) {
			passwordField.sendKeys(encrypt_decrypt.decrypt(encryptednewpassword, secretKey));
//			passwordField.sendKeys(Commonmethods.getCredential("new_Password"));
	
		}else {
				 Assert.fail("Invalid credentials");
     }
    	 
    	 Thread.sleep(1000);
    	 WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("loginPage","loginButton")));
    	 
    	 loginBtn.click();
    	 
    	 Commonmethods.switchtowindow(driver,"Movies - Kmbal Movies");
    	 
    	 
     }catch(Exception e){
    	 Assert.fail("Fails while login page");
     }
    }

    /**
     * Code to update password in homepage under profile
     */
    public void update_password() {
        try {
        	System.out.println(driver.getTitle());
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        	System.out.println(Commonmethods.getLocator("homepage","name"));
        	 WebElement name = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("homepage","name")));
        	 driver.findElement(Commonmethods.getLocator("homepage","name")).click();
      
        	 WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("homepage","profile")));
        	 driver.findElement(Commonmethods.getLocator("homepage","profile")).click();
        	 
        	 Commonmethods.switchtowindow(driver,"Profile - Kmbal Movies");
        	 
        	 JavascriptExecutor js = (JavascriptExecutor) driver;
         	js.executeScript("window.scrollBy(0, 500)");
         	
         	
        	 WebElement currentpassword = wait.until(ExpectedConditions.presenceOfElementLocated(Commonmethods.getLocator("homepage","currentpassword")));
        	 currentpassword.sendKeys(encrypt_decrypt.decrypt(encryptedPassword, secretKey));
        	 WebElement newpassword = wait.until(ExpectedConditions.presenceOfElementLocated(Commonmethods.getLocator("homepage","newpassword")));
        	 newpassword.sendKeys(encrypt_decrypt.decrypt(encryptednewpassword, secretKey));
        	 WebElement confirmpassword = wait.until(ExpectedConditions.presenceOfElementLocated(Commonmethods.getLocator("homepage","confirmpassword")));
        	 confirmpassword.sendKeys(encrypt_decrypt.decrypt(encryptednewpassword, secretKey));
        	 WebElement savebutton = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("homepage","savebutton")));
        	 savebutton.click();
        }catch(Exception e) {
        	Assert.fail("Fails while update password");
        }
    }
    
    public void logout() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement name = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("homepage","name")));
			name.click();
			WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(Commonmethods.getLocator("homepage","logout")));
			logout.click();
			Commonmethods.switchtowindow(driver,"Log in - Kmbal Movies");
			Thread.sleep(2000);
		}catch(Exception e) {
			Assert.fail("Fails while logout");
		}
	}
    
    public void login_with_updated_password() {
    			try {
    				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		    	 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Commonmethods.getLocator("loginPage","loginpagebutton"))));
    		    	 driver.findElement(Commonmethods.getLocator("loginPage","loginpagebutton")).click();
    		    	 Commonmethods.switchtowindow(driver,"Log in - Kmbal Movies");
    			}catch(Exception e) {
					Assert.fail("Fails while login with updated password");
				}
    }
    public void validate_homepage() {
    			try {	
    				Thread.sleep(2000);
    				if(driver.getTitle().equals("Movies - Kmbal Movies")) {
						System.out.println("User is on the home page");
						}else {
							Assert.fail("User is not on the home page");
						}
					
    			}catch(Exception e) {	
    					Assert.fail("Fails while validating the home page");
    			}
    }
}
